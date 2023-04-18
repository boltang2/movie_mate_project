package project.movie.mate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MovieMate_CastDAO;
import dao.MovieMate_CommentDAO;
import dao.MovieMate_Genre_RecDAO;
import dao.MovieMate_MovieDAO;
import dao.MovieMate_TagDAO;
import dao.Movie_CastDAO;
import dao.Movie_TagDAO;
import dao.Movie_UserDAO;
import dao.User_CastDAO;
import db.DB;
import vo.MovieMate_CastVO;
import vo.MovieMate_MovieVO;
import vo.Movie_CastVO;
import vo.Movie_UserVO;

@Controller
public class MovieController {

	private static final String VIEW_PATH = null;
	Movie_CastDAO movie_castdao;
	Movie_TagDAO movie_tagdao;
	Movie_UserDAO movie_userdao;
	MovieMate_CastDAO moviemate_castdao;
	MovieMate_CommentDAO moviemate_commentdao;
	MovieMate_Genre_RecDAO moviemate_genre_recdao;
	MovieMate_MovieDAO moviemate_moviedao;
	MovieMate_TagDAO moviemate_tagdao;
	User_CastDAO user_castdao;

	public MovieController(Movie_CastDAO movie_castdao, Movie_TagDAO movie_tagdao, Movie_UserDAO movie_userdao,
			MovieMate_CastDAO moviemate_castdao, MovieMate_CommentDAO moviemate_commentdao,
			MovieMate_Genre_RecDAO moviemate_genre_recdao, MovieMate_MovieDAO moviemate_moviedao,
			MovieMate_TagDAO moviemate_tagdao, User_CastDAO user_castdao) {
		this.movie_castdao = movie_castdao;
		this.movie_tagdao = movie_tagdao;
		this.movie_userdao = movie_userdao;
		this.moviemate_castdao = moviemate_castdao;
		this.moviemate_commentdao = moviemate_commentdao;
		this.moviemate_genre_recdao = moviemate_genre_recdao;
		this.moviemate_moviedao = moviemate_moviedao;
		this.movie_tagdao = movie_tagdao;
		this.user_castdao = user_castdao;
	}

	@RequestMapping("/data_insert.do")
	public String data_insert() throws IOException, ParseException {

		String[] category = { "sf", "가족", "갱스터", "계몽", "공포", "군사", "느와르", "드라마", "로드무비", "로맨스", "무협", "문예", "뮤지컬", "뮤직",
				"미스터리", "범죄", "사극", "사회물(경향)", "서부", "스릴러", "스포츠", "신파", "실험", "아동", "액션", "어드벤처", "옴니버스", "재난", "전기",
				"전쟁", "종교", "첩보", "청춘영화", "코미디", "판타지", "하이틴(고교)", "합작(번안물)", "활극" };

		for (String c : category) {
			String file_path = "C:\\embedded_kmz_spring\\work\\Project_movie_mate\\MOVIE_MATE\\src\\main\\webapp\\resources\\DB\\"
					+ c + ".txt";
			DB db_text = new DB();
			String[] file_path_arr = db_text.run(file_path);
			for (String link : file_path_arr) {
				// 1. 경로 확인
				String s = URLEncoder.encode(c, "utf-8");
				System.out.println("api 경로 : " + link);
				link = link.replace("genre=" + c, "genre=" + s);
				System.out.println("api 경로 : " + link);

				// 2. URL url 생성
				StringBuilder urlBuilder = new StringBuilder(link);
				// 3. URL 객체 생성.
				URL url = new URL(urlBuilder.toString());
				// 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 5. 통신을 위한 메소드 SET.
				conn.setRequestMethod("GET");
				// 6. 통신을 위한 Content-type SET.
				conn.setRequestProperty("Content-type", "application/json");
				// 7. 통신 응답 코드 확인.
				// System.out.println("Response code: " + conn.getResponseCode());
				// 8. 전달받은 데이터를 BufferedReader 객체로 저장.
				BufferedReader rd;
				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				// 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
				// 10. 객체 해제.
				rd.close();
				conn.disconnect();
				// 11. 전달받은 데이터 확인

				JSONParser parser = new JSONParser();
				JSONObject jsonObject = (JSONObject) parser.parse(sb.toString());
				JSONArray data = (JSONArray) jsonObject.get("Data");

				for (Object arr : data) {
					MovieMate_MovieVO moviemate_movievo = new MovieMate_MovieVO();
					JSONObject obj = (JSONObject) arr; // JSONArray 데이터를 하나씩 가져와 JSONObject로 변환해준다.
					JSONArray result = (JSONArray) obj.get("Result");
					for (Object arr2 : result) {
						JSONObject obj2 = (JSONObject) arr2;
						// System.out.print("title : " + obj2.get("title") + "/");
						String title = (String) obj2.get("title");
						title = title.trim();
						moviemate_movievo.setTitle(title);
						// System.out.print("nation : " + obj2.get("nation") + "/");
						String nation = (String) obj2.get("nation");
						nation = nation.trim();
						moviemate_movievo.setNation(nation);
						// System.out.print("img : " + obj2.get("posters") + "/");
						String img = (String) obj2.get("posters");
						String[] imgs = img.split("[|]");
						if (imgs.length == 0) {
							moviemate_movievo.setProfile_img("");
							moviemate_movievo.setBackground_img("");
						} else if (imgs.length == 1) {
							moviemate_movievo.setProfile_img(imgs[0]);
							moviemate_movievo.setBackground_img("");
						} else if (imgs.length >= 2) {
							moviemate_movievo.setProfile_img(imgs[0]);
							moviemate_movievo.setBackground_img(imgs[1]);
						}
						// System.out.println("genre : " + obj2.get("genre"));
						String genre = (String) obj2.get("genre");
						genre = genre.trim();
						moviemate_movievo.setGenre(genre);
						// System.out.println("company : " + obj2.get("company"));
						String company = (String) obj2.get("company");
						company = company.trim();
						moviemate_movievo.setCompany(company);
						JSONObject obj3 = (JSONObject) obj2.get("plots");
						JSONArray plot = (JSONArray) obj3.get("plot");
						for (Object arr3 : plot) {
							JSONObject obj4 = (JSONObject) arr3;
							System.out.println(obj4.get("plotText"));
							String content = (String) obj4.get("plotText");
							if (obj4.get("plotLang").equals("한국어")) {
								if (content.length() == 0) {
									content = "내용설명이 한국어로 존재하지 않습니다.";
								}
								moviemate_movievo.setMovie_info(content);
								break;
							} else {
								content = "내용설명이 한국어로 존재하지 않습니다.";
								moviemate_movievo.setMovie_info(content);
							}
						}
						JSONObject obj5 = (JSONObject) obj2.get("ratings");
						JSONArray rating = (JSONArray) obj5.get("rating");
						for (Object arr4 : rating) {
							JSONObject obj6 = (JSONObject) arr4;
							System.out.print("rating grade : " + obj6.get("ratingGrade") + " ");
							String grade = (String) obj6.get("ratingGrade");
							moviemate_movievo.setFilm_rating(grade.split("[|]")[0]);
							System.out.println("release date : " + obj6.get("releaseDate") + " ");
							String date = (String) obj6.get("releaseDate");
							if (date.length() < 8) {
								moviemate_movievo.setRelease_date("19800101");
							} else {
								String[] date_arr = date.split("[|]");
								for (String d : date_arr) {
									System.out.println(d);
									if (d.length() == 8) {
										int err = Integer.parseInt(d.substring(6, 8));
										if (err == 0 || err >= 32) {
											d = d.substring(0, 6) + "01";
										}
										moviemate_movievo.setRelease_date(d);
										break;
									}
								}
							}
							System.out.println("runtime : " + obj6.get("runtime"));
							String runtime = (String) obj6.get("runtime");
							moviemate_movievo.setRunning_time(runtime.split("[|]")[0]);
							break;
						}

						moviemate_moviedao.openApi_insert(moviemate_movievo);
						JSONObject obj7 = (JSONObject) obj2.get("directors");
						JSONArray director = (JSONArray) obj7.get("director");
						for (Object arr5 : director) {
							MovieMate_CastVO moviemate_castvo = new MovieMate_CastVO();
							JSONObject obj8 = (JSONObject) arr5;
							// System.out.println("director : " + obj8.get("directorNm"));
							String name = (String) obj8.get("directorNm");
							if (name == null || name.length() == 0) {
								continue;
							}
							moviemate_castvo.setName(name);
							moviemate_castvo.setType("director");
							moviemate_castvo.setProfile_img("no_data.jpg");
							moviemate_castdao.openApi_insert(moviemate_castvo);
							movie_castdao.openApi_insert(moviemate_movievo, moviemate_castvo);
						}
						JSONObject obj9 = (JSONObject) obj2.get("actors");
						JSONArray actor = (JSONArray) obj9.get("actor");
						for (Object arr6 : actor) {
							MovieMate_CastVO moviemate_castvo = new MovieMate_CastVO();
							JSONObject obj10 = (JSONObject) arr6;
							// System.out.println("actor : " + obj10.get("actorNm"));
							String name = (String) obj10.get("actorNm");
							if (name == null || name.length() == 0) {
								continue;
							}
							moviemate_castvo.setName(name);
							moviemate_castvo.setType("actor");
							moviemate_castvo.setProfile_img("no_data.jpg");
							moviemate_castdao.openApi_insert(moviemate_castvo);
							movie_castdao.openApi_insert(moviemate_movievo, moviemate_castvo);
						}
						System.out.println("---------------------------");
					}
				}
			}
		}

		return "/WEB-INF/views/data/data_check.jsp";
	}

	@RequestMapping(value = { "/", "/movie_mate_main_screen.do" })
	public String movie_mate_main_screen(Model model) {

		List<MovieMate_MovieVO> boxoffi_list = moviemate_moviedao.boxoffi_list();
		System.out.println(boxoffi_list.size());
		model.addAttribute("boxoffi_list", boxoffi_list);
		// 테스트 중입니다.
		List<MovieMate_MovieVO> top10_list = moviemate_moviedao.top10_list();
		/* System.out.println(top10_list.size()); */
		model.addAttribute("top10_list", top10_list);

		return "/WEB-INF/views/show/movie_mate_main_screen.jsp";
	}

	/*
	 * // 명작 영화
	 * 
	 * @RequestMapping(value = {"/","/movie_mate_main_screen.do"} ) public String
	 * movie_mate_main_screen2(Model model) {
	 * 
	 * List<MovieMate_MovieVO> masterpiece_list =
	 * moviemate_moviedao.masterpiece_list(); model.addAttribute("masterpiece_list",
	 * masterpiece_list); return "/WEB-INF/views/show/movie_mate_main_screen.jsp"; }
	 */
}
