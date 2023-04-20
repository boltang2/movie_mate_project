package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MovieMate_CastVO;
import vo.MovieMate_MovieVO;
import vo.Movie_CastVO;

public class MovieMate_CastDAO {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int openApi_insert(MovieMate_CastVO castvo) {

		int count = sqlSession.selectOne("mmcast.openApi_count", castvo);
		if (count < 1) {
			int res = sqlSession.insert("mmcast.openApi_insert", castvo);
		}

		return count;
	}

	// 해당 영화에 출연한 모든 배우/감독 리스트
	public List<MovieMate_CastVO> movie_castList(MovieMate_MovieVO moviemate_movievo) {
		
		List<Movie_CastVO> list = sqlSession.selectList("mcast.selectList", moviemate_movievo);
		List<MovieMate_CastVO> cast_list = new ArrayList<MovieMate_CastVO>();
		for (Movie_CastVO movie : list) {
			cast_list.add(sqlSession.selectOne("mmcast.selectCastIdx", movie));
		}
		
		return cast_list;
	}
}
