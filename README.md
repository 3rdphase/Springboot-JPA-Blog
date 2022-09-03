# Springboot-JPA-Blog

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
