package com.lol.search.bot.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lol.search.bot.dto.CurrentGameInfo;
import com.lol.search.bot.dto.CurrentGameParticipant;
import com.lol.search.bot.dto.LeagueEntryDTO;
import com.lol.search.bot.dto.MiniSeriesDTO;
import com.lol.search.bot.dto.SummonerDTO;

@RestController
public class RiotRestController {
	private static final String SEARCH_NAME_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	private static final String SEARCH_SUMMONER_INFO_URL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";
	private static final String SEARCH_CURRENT_GAME_INFO = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
	
	private static final String API_KEY = "?api_key=";
	private static String token = "";
	
	@PostMapping(value = "api/setting")
	public String tokenSetting(HttpServletRequest request, HttpServletResponse response)  {
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader br;
		try {
			br = request.getReader();
			while((line = br.readLine())!=null) {
				sb.append(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		System.out.println(sb.toString());
		JSONObject ob = new JSONObject(sb.toString());
		System.out.println(ob.get("token"));
		
		token = (String) ob.get("token");
		response.setCharacterEncoding("UTF-8");
		if("".equals(token)) return "contact developer";
		else return "Setting complete";
	}
	
	// 이름 검색 및 리그 정보 경신 (랭크 등)
	@GetMapping(value = "/api/search/{name}")
	public LeagueEntryDTO[] seachLeague(@PathVariable String name) {
		String summonerName = name.replace(" ", "");
		SummonerDTO summonerDto = searchEncName(summonerName);
		LeagueEntryDTO[] league_info = null;

		if (summonerDto != null) {
			String requestURL = SEARCH_SUMMONER_INFO_URL + summonerDto.getId() + API_KEY + token;

			league_info = (LeagueEntryDTO[]) connectAPI(requestURL, league_info, LeagueEntryDTO[].class);
		}
		
		return league_info;
	}

	// current game info
	@GetMapping(value = "/api/game/{name}")
	public void currentGameInfo(@PathVariable String name, HttpServletResponse response) {
		String summonerName = name.replace(" ", "");

		SummonerDTO summonerDto = searchEncName(summonerName);

		CurrentGameInfo currentGameInfo = null;

		JSONObject jsonObject =  new JSONObject();
		
		if (summonerDto != null) {
			String requestURL = SEARCH_CURRENT_GAME_INFO + summonerDto.getId() + API_KEY + token;
			currentGameInfo = (CurrentGameInfo) connectAPI(requestURL, currentGameInfo, CurrentGameInfo.class);

			List<CurrentGameParticipant> participants;
			// queue type 에 따른 데이터만 높은 데이터만 가져올까/ 
			
			if (null == currentGameInfo)
				participants = new ArrayList<>();
			else
				participants = currentGameInfo.getParticipants();
			if (!participants.isEmpty()) {
				for (int i = 0; i < participants.size(); i++) {
					// 게임타입별로 넣어 보자
					JSONObject user =  new JSONObject();
					
					CurrentGameParticipant participant = participants.get(i);
					user.put("name", participant.getSummonerName());
					user.put("team", participant.getTeamId());
					LeagueEntryDTO[] userEntry = seachLeague(participant.getSummonerName());
					// ranking 정보
					LeagueEntryDTO userRankInfo  = null;
					if(userEntry.length == 2) {
						userRankInfo = userEntry[1];
					} 
					else if (userEntry.length == 1) {
						userRankInfo= userEntry[0];
					}
					if(userRankInfo != null ) {
						JSONObject rankJson =  new JSONObject();
						double win = userRankInfo.getWins();
						double lose = userRankInfo.getLosses();
						double rate  = win / (win+lose);
						rankJson.put("type",userRankInfo.getQueueType());
						rankJson.put("tier",userRankInfo.getTier());
						rankJson.put("rank",userRankInfo.getRank());
						rankJson.put("score",userRankInfo.getLeaguePoints());
						rankJson.put("win",win);
						rankJson.put("lose",lose);
						rankJson.put("rate", rate*100.0);
						MiniSeriesDTO mini = userRankInfo.getMiniSeries();
						if(mini != null) {
							JSONObject miniInfo = new JSONObject();
							miniInfo.put("target",mini.getTarget());
							miniInfo.put("progress",mini.getProgress());
		
							rankJson.put("miniSeries", miniInfo);;
						}
						user.put("Rank",rankJson);
					}
					jsonObject.put(Integer.toString(i),user);
				}
			}
		}
		
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SummonerDTO searchEncName(String name) {
		SummonerDTO summoner = null;

		String summonerName = name.replace("%20", " ");

		String requestURL = SEARCH_NAME_URL + summonerName + API_KEY + token;
		summoner = (SummonerDTO) connectAPI(requestURL, summoner, SummonerDTO.class);
		return summoner;
	}

	private static Object connectAPI(String requestURL, Object getObject, Class classNames) {
		ObjectMapper objectMapper = new ObjectMapper();

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(requestURL); // GET 메소드 URL 생성

		try {
			HttpResponse response = client.execute(getRequest);
			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				String body = handler.handleResponse(response);
				getObject = objectMapper.readValue(body, classNames);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getObject;
	}

}
