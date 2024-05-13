# 안드로이드(Android)

# ▨ 안드로이드 앱 컴포넌트 ▨
## :pushpin: 안드로이드 앱 컴포넌트
1. Activity : 앱의 화면을 담당하는 기본 구성 요소
2. Intent : 액티비티 간의 전환 또는 외부 앱과의 데이터 교환을 위한 메시지
3. Service : 백그라운드에서 동작하는 작업 단위
4. Broadcast Receiver : 시스템 또는 다른 앱에서 발생하는 이벤트 수신
5. Content Provider : 앱 간 데이터 공유를 위한 인터페이스

# ▨ 안드로이드 개발 환경 ▨
## :pushpin: 안드로이드 개발 환경
- 안드로이드 스튜디오(IDE)
- 안드로이드 SDK : 안드로이드 앱을 개발하기 위한 도구 및 라이브러리 모음
- 에뮬레이터(Emulator, AVD) : 안드로이드 앱을 테스트할 수 있는 가상 디바이스

# ▨ XML(eXtensible Markup Language) ▨
## :pushpin: XML(eXtensible Markup Language)
- 데이터를 구조화하고 나타내는 마크업 언어
- 사람이 이해할 수 있는 구조
- 기계가 해석할 수 있는 데이터 형식
- 반정형 데이터

## :pushpin: XML 구성 요소
1. 선언부
2. 태그(Tag)
    - 데이터를 감싸는 구조화된 요소
    - 시작 태그와 종료 태그의 쌍으로 이루어져 있다.(열면 닫아야 한다.)
   ```xml
     <data>데이터 내용</data>
   ```
3. 엘리먼트(Element)
    - 시작 태그와 종료 태그 사이에 있는 컨텐츠
    - 태크 내부의 하위 태그, 하위 엘리먼트(요소)를 포함한다.
    - 태그 + 컨텐츠(내용)
   ```xml
   <person>
        <name>홍길동</name>
        <age>30</age>
   </person>
   ```
4. 속성(Attributes)
    - 태그에 추가 정보를 제공
    - Key-Value 쌍
   ```xml
   <person name="홍길동" age="30" />
   ```
5. 네임스페이스(Namespace)
    - 태그 이름의 충돌을 피하기 위해 고유한 접두사를 부여
    - 선언부 또는 태그 내부의 'xmlns' 속성을 사용하여 URI로 정의
   ```xml
   <myname:person xmlns:myname="http://myname.com/myname">
       <myname:name>홍길동</myname:name>
   </myname:person>
   ```
- 주의사항
    - XML 태그는 대소문자를 구분한다.
    - 태그의 쌍은 정확하게 매칭이 되어야 한다.
    - 속성의 값은 반드시 큰 따옴표나 작은 따옴표로 감싸야 한다.
    - 루트 엘리먼트(최상위)는 하나여야 한다.

# ▨ 뷰(View) ▨
## :pushpin: 뷰의 레이아웃
- [뷰의 레이아웃](https://developer.android.com/develop/ui/views/layout/declaring-layout?hl=ko)
- View 클래스 : (화면 구성과 관련된 클래스)
    - ViewGroup : View의 하위 클래스지만, 화면에는 아무것도 출력하지 않고 다른 뷰 여러 개를 묶는 그릇 역할을 하는 클래스다.
        - XXXLayout : 뷰의 컨테이너 역할
    - TextView, XXXView : 특정 UI를 출력할 목적으로 사용하는 클래스

## :pushpin: 뷰 바인딩(View Biding)
- 레이아웃 XML 파일에 선언한 뷰 객체를 코드에서 쉽게 이용하는 방법
- 모듈 단위 `build.gradle` 파일 `android` 영역에 설정 선언 추가
  ```
  android {
   ... (생략)
   viewBinding { enable = true }
   ...
  }
  ```
- 그레이들을 동기화 하면, 자동으로 뷰 객체 포함하는 클래스가 생성된다.
- 레이아웃 XML 파일의 이름을 따름
    - 클래스 이름 : 첫글자 및 _ 뒤를 대문자로 바꾼 후 'Binding' 추가
        - activity_main.xml → ActivityMainBinding
  ```kt
       // 바인딩 객체 획득(View Binding)
       val binding = ActivityBindingBinding.inflate(layoutInflater)

       // 바인딩 객체로 화면을 출력
       setContentView(binding.root)

       // findViewById를 사용하지 않고 뷰 객체 사용
       binding.visibleButton.setOnClickListener {
           binding.targetView.visibility = View.VISIBLE
       }
  ```