# movie_mate
<<<<<<< HEAD
무매 화이팅ヽ(✿ﾟ▽ﾟ)ノ
=======
영화 소개 및 리뷰가능 사이트




## 프로젝트 소개
왓챠피디아를 참고하여 만든 영화 소개  리뷰 사이트 입니다.




## 개발 기간
* 23.04.10 ~ 23.05.15
* 04.10 ~ 04.11 클론코딩 대상 결정
* 04.11 ~ 04.14 데이터베이스 스키마 설계 밑 html 전개도 구축
* 04.14 ~ 04.19 oepn api 기반 영화 데이터를 원하는 형태로 정제후 기본 데이터 베이스 구축 밑 스프링 베포
* 04.19 ~ 05.15 사이트 제작




## 개발 환경
- "Java 11"
- "JDK 1.11.0"
- "IDE : STS 3.7"
- "Database : Oracle DB (11xe)"
- "ORM : Mybatis"

## 멤버

-김현준		

            1. 기본 SPRING  배포 버전 제작
            2. 상호작용 리스트 - 좋아요, 댓글일 경우 리스트 출력, 더보기, 시간순 영화리스트 출력   
		3. 상호작용 리스트 - 별점일 경우, 드랍다운 구현, 별점별 영화출력 더보기 구현   
		4. 상호작용 리스트 - 별점일 경우 별점순, 각종 기준점 정하기    
		5. 메인화면 - 예상별점 높은 영화 데이터 추출
		6. 메인화면 - 임의의 태그를 뽑아 태그가 포함된 영화 데이터 가져오기
		7. 영화 선택 페이지 - 영화를 만든 제작진과 댓글달린 목록 출력
		8. 영화 선택 페이지 - 선택한 영화정보 출력
		9. 영화 선택 페이지 - 비슷한 작품 영화리스트 출력
		10. 헤더 - 자체 회원가입 기능 구현
		11. 대댓글 페이지 - 클린봇 기능 구현

-고민지		

            1. 영화 선택 페이지 - 댓글 수정, 삭제, 좋아요, 댓글 수 기능 구현
		2. 영화 선택 캐스트 페이지 - 캐스트 정보 출력 및 좋아요 증가 및 해당 캐스트의 작품 리스트 출력
		3. 댓글 목록 페이지 - 댓글 클릭시 해당 댓글과 대댓글 목록 출력
		4. 대댓글 페이지 - 댓글 수정, 삭제 , 좋아요, 댓글 수 기능 상호작용 가능하도록 데이터 가져오기
		5. 대댓글 페이지 - 대댓글 등록, 수정, 삭제 기능 구현
		6. 검색창 - 영화, 배우, 감독, 유저 검색 기능 구현
		7. 검색창 - 내가 검색한 영화, 영화들을 만든 감독리스트, 출연한 배우리스트 출력하기
		8. 헤더 - 홈키, 선택, 검색, 로그인, 회원가입, 버튼 추가
		9. 헤더 - 다크모드 기능 구현
	
-채민석		

            1. 메인 화면 임의의 기준으로 인플루언서를 뽑아 추천한 영화 데이터 가져오기
		2. 메인 화면 박스오피스 기준 영화 데이터 가져오기
		3. 메인 화면 명작 영화 데이터 가져오기
		4. 메인 화면 임의의 기준으로 배우를 뽑아 배우가 출연한 영화 데이터 가져오기
		5. 평균별점 높은 기준 영화 데이터 가져오기
		6. 메인 화면 장르 기반으로 추천한 영화 데이터 가져오기
		7. 마이페이지 
		8. 로그인 카카오 open api
		
-박성준		

            1. 메인 화면 Top10 기준 영화 데이터 가져오기
            2. 마이 페이지 _> 상호작용리스트 댓글일 경우 내가 단 영화 리스트 출력
            3. 마이 페이지 -> 상호작용리스트 내가 댓글 단 목록
            4. 수정 페이지
            5. 메인 화면 임의의 기준으로 감독을 뽑아 감독이 만든 영화 데이터 가져오기  

-장현상		

            1. 메인 화면 임의의 기준으로 인플루언서를 뽑아 추천한 영화 데이터 가져오기
		2. 메인 화면 박스오피스 기준 영화 데이터 가져오기
		3. 메인 화면 명작 영화 데이터 가져오기
		4. 메인 화면 임의의 기준으로 배우를 뽑아 배우가 출연한 영화 데이터 가져오기
		5. 마이 페이지 
		6. 로그인 네이버 open api
		7. 더 보기 영화 모든 정보 출력
		8. 로그인 화면 우리 자체 회원 기능 구현
		9. 풋터(footer) 개발자 정보 담은 링크 배열 출력




## 주요기능 

### Open Api
- 영화진흥원에서 영화데이터를 json으로 가져옴

목록 : 영화이름, 포스터이미지(1,2), 출연진, 개봉날짜, 장르, 국가, 영화설명, 제작, 런타임, 관람등급가

### 헤더 (header.jsp)

#### 로그인
- 일반회원 로그인 :

1. 로그인 : 유저 DB 접속 후 로그인 성공/실패
- 카카오톡 로그인 :

1. 카카오 로그인 : 카카오톡 open api를 이용, 사용자가 카카오 계정을 입력하면 해당 계정의 이메일과 이름을 가져옴.
해당 계정의 이메일과 이름이 유저 DB에 존재하면 로그인 성공, 아니라면 해당 이메일과 이름을 기반하여
회원가입페이지로 이동후 회원가입 절차를 밟음.
- 네이버 로그인 :

1. 네이버 로그인 : 네이버 open api를 이용, 사용자가 네이버 계정을 입력하면 해당 계정의 이메일과 이름을 가져옴.
해당 계정의 이메일과 이름이 유저 DB에 존재하면 로그인 성공, 아니라면 해당 이메일과 이름을 기반하여
회원가입페이지로 이동후 회원가입 절차를 밟음.

#### 회원가입
- 일반회원 회원가입 :

1. 중복체크 : 각 항목 별 정규식을 통해 분기점을 형성 후 중복체크시 Ajax로 프라이머리 키, 유니크 요소 판단
2. 회원가입 : 모든 분기점을 통과했으면 유저DB에 저장

- 카카오, 네이버 로그인 : 

1. 자동로그인 : 각 open api를 활용하여 유저 닉네임과 이메일을 불러온 후 해당 닉네임과 이메일로 회원가입이
되어있는 상태면 로그인 완료 분기점으로 이동
2. 회원가입 : 해당 아이디와 이메일로 회원가입이 되어있지 않은 상태면 일반회원 회원가입과 동일한 기능으로 
회원가입 유도

#### 검색 기능
- 검색

1. 검색하기 : 검색란에 텍스트를 입력하면 총 3가지 기준으로 데이터를 정렬한다. 내가 검색한 텍스트가 감독이나 배우, 영화 이름, 회원 이름
총 세 가지 기준으로 데이터를 정산하고 감독이나 배우인 경우 해당 인물이 출연한 영화 목록, 영화 이름도 마찬가지로 영화 리스트에 저장후 바인딩, 회원 이름일 경우
검색한 텍스쳐가 포함된 모든 유저를 리스트에 저장후 바인딩하여 해당 jsp에 출력한다.

#### 마이페이지
- 마이페이지 이동

1. 마이페이지로 이동

#### 다크모드
- 다크모드 적용

1. 다크모드 : 세션에 모드버전을 저장에 새로고침이나 페이지 이동시 모드가 유지되도록 설정, 바디에 다크모드 css를 add해 모든 페이지에서 해당 dark_mode css 속성으로 적용되게 바꿈
2. 화이트모드 : 다크모드 해제시 dark_mode를 remove 후 white_mode를 body에 

### 풋터 (footer.jsp)

#### 각종 텍스트
- 왓챠피디아 풋터 그대로 가져와서 대입


### 메인화면 (movie_mate_main_screen.jsp)
- 리스트 출력

1. 리스트 출력 : 영화정보DB에서 내가 원하는 형태로 8가지 주제(명작, 박스오피스, top 10, 이주의 배우, 감독, 인플루언서, 장르, 평균별점)로 각각 상위 15개 항목을 뽑아서 출력한다.
현재 이주의 시리즈가 데이터 베이스를 두번 가게 설계 되어있는데 추후에 한번에 처리하도록 쿼리 리팩토리 할 예정

2. 로그인 정보 세션 초기화 : 맨 처음으로 사이트 방문시 로그인 관련 세션을 초기화 후 생성, 그 이후 부터는 세션이 선언 되어 있으면 초기화 하지 않음


### 영화선택화면 (movie_mate_choice_screen.jsp)
- 어떤 페이지 에서든 영화를 클릭하면 오게되는 jsp
모든 영화 정보 출력 및 해당 영화리뷰 댓글, 관련영화 출력

1. 영화정보 출력 : 해당 영화 포스터 이미지와 장르, 카테고리 출력

2. 별점, 보고싶어요, 글쓰기 기능 :

	1) 별점 : 클릭 시 로그인이 되어 있지 않다면 로그인 창으로 유도, 로그인이 되어 있다면 movie_user DB에 해당 movie_idx와 user_idx 저장후 별점 준 만큼 star_score에 값 인가. 그 후 Ajax로 별점 점수를 받아와 화면에 표시
별점을 수정하면 해당 데이터 테이블 star_score 값 변경
	2) 보고싶어요 : 클릭시 로그인이 되어 있지 않다면 로그인 창으로 유도, 로그인이 되어있다면 movie_user DB에 해당 movie_idx와 user_idx 저장후 want_view 값을 yes로 인가, 다시 누르면 해당 데이터 테이블 값을 yes면 no, no면 yes로 변경
	3) 쓰기 : 클릭시 로그인이 되어 있지 않다면 로그인 창으로 유도, 로그인이 되어있다면 글쓰기 div를 생성후 
글쓰기가 완료 됬다면 moviemate_comment DB에 데이터 저장

3. 기본정보 출력 : 해당 영화 설명과 더 자세한 정보를 출력, 모든 정보를 보고 싶으면 영화 더보기 (movie_mate_choice_moreInfo_screen.jsp)으로 이동

4. 출연/제작 : 해당 영화에 출연한 배우와 감독 리스트 출력 클릭시 인물 정보 소개(movie_mate_choiceCast_screen.jsp)으로 이동 

5. 코멘트 : 해당 영화에 리뷰를 달고, 보고싶어요나 별점을 준 댓글 리스트만 보이게 출력

	1) 댓글 클릭시 해당 댓글의 정보를 가지고 있는 (movie_mate_comment_moreInfo_screen.jsp)로 이동
	2) 해당 글의 좋아요 개수는 해당 comment_idx를 가지고 있는 모든 user_comment 테이블에서 isup이 yes인 갯수를 count해서 출력
	3) 좋아요 클릭시 user_comment 테이블에 해당 comment_idx와 졸아요를 누른 user_idx를 프라이머리 키로 하는 테이블 생성후 isup 값을 yes로 인가, 중복 클릭시 yes라면 no, no라면 yes로 수정
	4) 더보기 클릭시 댓글 리스트를 출력하는 (movie_mate_comment_screen.jsp) 으로 이동

6. 비슷한 영화 :  해당 영화가 가지고 있는 장르, 국가를 사용하여 moviemate_movie테이블로 부터 총 12개의 영화를 검색하여 출력

	1) 장르가 "," 기준으로 나누어져 있기 때문에 장르 String 값을 배열로 변경하여 배열 크기만큼 적절하게 나누어 각 장르별 영화를 비슷한 개수로 선정하여 뽑음. 만약 12개가 되지 않는다면 12개가 될때 까지 각 장르별 뽑는 개수를 늘려 12개를 맞출때 까지 늘림

7. 광고 : 광고 클릭시 실제 왓챠 사이트로 이동


### 영화검색화면 (movie_mate_search_screen.jsp)
- 헤더에서 검색시 그 검색결과를 출력하는 화면

1. 컨텐츠 : 내가 검색한 텍스트가 포함된 모든 매체를 포함한 결과 리스트를 출력, 원래는 영화만 다루는 것이 아닌 책이나 웹툰등 다른 매체도 다룰려 했으나 현재 영화 밖에 없기 떄문에 영화 리스트만 나오는 상태

2. 영화 : 1.컨텐츠에서는 모든 매체를 종합적으로 보여줬다면 그 중 영화에 해당되는 매체만 분류해서 출력 추후 리팩토링시 웹툰이나 책 부분도 추가할 예정

3. 유저 : 내가 검색한 텍스트가 username에 포함된 모든 유저리스트를 출력

### (배우,감독)선택화면 (movie_mate_choiceCast_screen.jsp)
- 어디서든 배우, 감독 클릭시 이동하는 화면, 해당 배우가 출연한 영화 리스트와 간단한 인적사항 출력

1. 인물정보 출력: 해당 인물의 이름과 감독인지 배우인지 출력

2. 좋아요 : 해당 인물에게 좋아요를 누를 경우 비로그인시 로그인 유도, 클릭 시 user_cast DB에 해당 cast_idx와 로그인 한 user_idx를 프라이머리 키를 가지고 있는 데이터 생성후 isup에 yes인가, 중복 클릭시 isup이 yes이면 no, no이면 yes로 변경 후 Ajax로 값을 받아와 해당 분기에 맞게 숫자와 icon 변경

3. 좋아요 개수 : 해당 cast_idx를 가지고 있는 모든 user_cast 테이블에서 isup이 yes인 개수 출력

4. 출연 영화리스트 : 해당 cast_idx를 가지고 있는 모든 movie_cast 테이블 리스트에서 영화 정보를 가져옴
현재 moviemate_cast, movie_cast, moviemate_movie 테이블을 조인하여 단 한번의 쿼리문으로 해결이 가능한데
비효울적으로 쿼리문이 작성되있어 추후 리팩토리 할 예정


### 댓글리스트화면 (movie_mate_comment_screen.jsp)
- 해당 영화의 리뷰들만 모아둔 jsp
- moviemate_movie, moviemate_user, user_comment, moviemate_comment 4개의 테이블을 조인해서 comment_idx, movie_idx, 해당 댓글의 달린 댓글의 개수, 준 별점이나 보고싶어요, 댓글 내용, 해당 댓글이 받은 추천 개수를 각 댓글마다 출력

1. 영화선택화면에서 언급한 5.코멘트 기능과 동일함.

### 해당댓글정보화면 (movie_mate_comment_moreInfo_screen.jsp)
- 해당 댓글의 정보와 대댓글 리스트를 출력하는 jsp

1. 원댓글정보출력 : 댓글을 단 영화 정보, 별점, 보고싶어요, 작성자 이름, 내용 출력

2. 좋아요 : 영화선택화면 5.코멘트 기능과 동일

3. 공유 : 현재 불가능 리팩토링시 구현 예정

4. 클린봇 : 현재 대댓글 목록 중에서 욕설이 있을경우 필터링해서 필터링된 댓글 안보이게 한다

5. 대댓글정보출력 : 해당 댓글에 달린 모든 대댓글 리스트를 출력, 만약 현재 로그인 한 계정과 일치한 댓글이 존재 할경우 해당 글만 수정과 삭제가 가능하도록 구

### 마이페이지 (movie_mate_mypage_screen.jsp)
- 해당 유저의 인적사항, 취향분석, 유저가 상호작용한 리스트 링크

1. 현재 내 프로필 사진과 유저이름 출력

2. 회원 정보 수정 링크 : (movie_mate_modify_screen.jsp)로 이동

3. 취향분석 링크 : (movie_mate_analyze_screen.jsp)로 이동

4. 영화 링크 : (movie_mate_myChoice_moreInfo.jsp)로 이동


### 회원정보수정 (movie_mate_modify_screen.jsp)
- 회원정보 수정

1. 프로필 사진 수정 : multipart/form-data 를 통해 이미지를 받아 upload의 절대경로로 이미지 저장

2. 이름 수정 : 정규식, 중복체크 적용 만약 현재 이름 그대로 싶은 경우만 중복 예외 처리

3. 비밀번호 수정: 정규식 적용 비밀번호 일치여부 확인 구현

### 취향분석 (movie_mate_analyze.jsp)
- 유저가 상호작용한 모든 영화 리스트를 토대로 각 카테고리별 점수를 내 순위와 내가 좋아하는 성향을 표시해준다

1. 별점 그래프 : 현재 로그인한 유저가 별점을 준 모든 영화 리스트를 그래프화 한다. 내가 가장 많이 준 별점, 갯수, 평균을 도식화 해서 보여준다.

2. 선호배우, 국가, 장르 : 별점을 준 모든 영화에 출연한 배우, 국가, 장르리스트, 해당 항목에 따라 출연한 별점을 기반으로 평균과 개수를 도식화 해서 높은 점수를 받은 순으로 항목을 출력한다.

3. 영화감상시간 : 내가 상호작용한 모든 영화의 상영시간을 합쳐 시간단위로 출력

### 영화링크 (movie_mate_mychoice_moreInfo.jsp)
- 유저가 별점을 준 영화 리스트와 보고싶어요를 누른 영화리스트를 구별해서 출력한다
>>>>>>> 2dfd199c605d3b5f40f03d7ec6a9738da2879fe2
