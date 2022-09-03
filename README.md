# Springboot-JPA-Blog

참고 : https://getinthere.tistory.com/16


1. jar파일 설치 => 커멘드에서 java -jar ???.jar
    1) eclipse에서 자바파일 실행 => ctrl + f11
    2) 필요없는 import 삭제 => Ctrl+Shift+O

2. 자바 웹 개발환경 설정
    1) STS4 JavaEE 플러그인 설치(Jsp웹 개발환경) 
	      Help - Eclipse MarketPlace-검색어 : eclipse web-목록 : Eclipse Enterprise Java and Web Developer Tools 3.26
	      예전에는 웹 개발환경도 기본적으로 지원을 했으나 최근에는 리액트 등 의 프론트는 별도의 개발환경에서 작업하기때문에 기본제공 안함
    2) STS4 Javascript 파일 인식 설정
	      Window-Prefrences-General-Editors-File Association *.js Add after Generic Text Editor...(default)
    3) STS4 폰트 및 인코딩
	      Window-Prefrences-font검색-Color and Fonts-Basic-Text Font-글꼴 Verdana 14Point
	      Window-Prefrences-enc검색 후 모든 파일 과 workspace UTF-8로
    4) STS4 Lombok 플로그인설치
	      https://projectlombok.org/download 다운로드
	      해당폴더 마우스 우측 Git Bash Hear-java -jar Lombok.jar-sts실행파일 선택-설치

3. Spring Starter Project

![image](https://user-images.githubusercontent.com/49021504/188260243-2db7a96e-796f-4731-b884-4f1474569deb.png)
![image](https://user-images.githubusercontent.com/49021504/188260251-b2d14a9d-e347-45ca-a00d-90c173f971a6.png)

4. dependence => project-pom.xml-dependences에 추가
	
	<!-- 시큐리티 태그 라이브러리 -->
	<dependency>
	  <groupId>org.springframework.security</groupId>
	  <artifactId>spring-security-taglibs</artifactId>
	</dependency>

	<!-- JSP 템플릿 엔진 -->
	<dependency>
	  <groupId>org.apache.tomcat.embed</groupId>
	  <artifactId>tomcat-embed-jasper</artifactId>
	</dependency>

	<!-- JSTL -->
	<dependency>
	  <groupId>javax.servlet</groupId>
	  <artifactId>jstl</artifactId>
	</dependency>
5. mysql
	1)한글설정 => my.ini
	[client]
		default-character-set=utf8
	[mysql]
		default-character-set=utf8
	[mysqld]
		collation-server = utf8_unicode_ci
		init-connect='SET NAMES utf8'
		init_connect='SET collation_connection = utf8_general_ci'
		character-set-server=utf8
	2)한글설정확인
		show variables like 'c%';
	3)사용자생성 및 권한
		-- 유저이름@아이피주소
		create user 'cos'@'%' identified by 'cos1234';
		-- ON DB이름.테이블명
		-- TO 유저이름@아이피주소
		GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
		CREATE DATABASE blog CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
		use blog;
	4)프로젝트연결
		src/main/resources/application.yml
		spring:
		  datasource:
			driver-class-name: com.mysql.cj.jdbc.Driver
			url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
			username: cos
			password: cos1234
5. pom.xml에서 jpa, mysql 관련 주석풀고 서버 재시작

6. git
	기본값으로 사용할 Git 사용자 이름과 이메일 설정(global 옵션)
	$ git config --global user.name "아이디"
	$ git config --global user.email 이메일주소
	$ cat ~/.gitconfig
	[user]
		name = 아이디
		email = 이메일주소
		
	현재 저장소의 user, email 설정값을 확인하는 방법
	$ git config user.name	
	$ git config user.email

7. 스프링 일반
	src/main/resources/static 폴더는 브라우저가 인식할수있는 정적파일만 위치한다. ex) html, js, 이미지 등 단, jsp 파일은 찾아는주지만 파싱이 안됨
	파일리턴 기본경로  : src/main/resources/static/파일...
	
8. JSP
  mvc:
    view:
      prefix: /WEB-INF/views 컨트롤러가 리턴할때 앞에 붙여주는것
      suffix: .jsp 컨트롤러가 리턴할때 뒤에 붙여주는것
      
	src/main/webapp/WEB-INF/views/JSP파일...

	jasper dependence 설정
