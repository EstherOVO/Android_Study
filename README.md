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
  
## :pushpin: 뷰를 배치하는 레이아웃
1. 수평, 수직으로 배치 - `LinearLayout`
2. 상대적인 위치로 배치 - `RelativeLayout`
3. 겹쳐서 배치 - `FrameLayout`
4. 격자 형태로 배치 - `GridLayout`
5. 제약조건으로 배치 - `ConstraintLayout`

## :pushpin: 사용자 이벤트 처리
1. 터치 이벤트
2. 키 이벤트
3. 뷰 이벤트

#  ▨ 권한(Permission) ▨
# :pushpin: 1. 일반 권한(Normal Permissions)
- 일반 권한은 민감하지 않은 데이터와 기능에 접근하는 데 필요한 권한
- 이 권한들은 앱 설치 시 자동으로 부여되며, 사용자에게 별도의 허가를 요청하지 않아도 된다.
- 일반 권한은 사용자 개인 정보나 장치 보안에 큰 영향을 미치지 않는 기능에 사용된다.
- 예시
  - 인터넷 접근 권한(`INTERNET`)
  - 네트워크 상태 확인 권한(`ACCESS_NETWORK_STATE`)
  - Wi-Fi 상태 확인 권한(`ACCESS_WIFI_STATE`)
- 선언 방법
  - 일반 권한은 `AndroidManifest.xml` 파일에 선언한다.
  - 예를 들어, 인터넷 접근 권한을 선언하려면 아래와 같이 작성한다.
    ```xml
    <manifest xmlns:android="<http://schemas.android.com/apk/res/android>"
        package="com.busanit.myfirstapp">
    
        <uses-permission android:name="android.permission.INTERNET" />
    
        <!-- Other declarations -->
    
    </manifest>
    ```

## :pushpin: 2. 위험 권한(Dangerous Permissions)
- 위험 권한은 민감한 데이터나 장치 기능에 접근할 때 필요한 권한
- 이러한 권한들은 사용자의 개인 정보나 장치 보안에 큰 영향을 미칠 수 있기 때문에, 사용자가 명시적으로 허가해야 한다.
- 앱 실행 중에 사용자가 허가를 승인하거나 거부할 수 있다.
- 예시
  - 위치 정보 접근 권한(`ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`)
  - 카메라 사용 권한(`CAMERA`)
  - 연락처 접근 권한(`READ_CONTACTS`, `WRITE_CONTACTS`)
  - 저장소 접근 권한(`READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`)

## :pushpin: 권한 요청 처리 절차
1. 권한 선언: `AndroidManifest.xml` 파일에 필요한 권한을 선언
2. 권한 확인: 앱 실행 시 `ContextCompat.checkSelfPermission()` 메서드로 권한 확인
3. 권한 요청: 권한이 부여되지 않은 경우 `ActivityCompat.requestPermissions()` 메서드로 사용자에게 권한 요청
4. 결과 처리: `onRequestPermissionsResult()` 메서드에서 권한 요청 결과 처리

## :pushpin: 선언 및 요청 방법
1. 권한 선언: `AndroidManifest.xml` 파일에 위험 권한을 선언합니다.
    ```xml
    <manifest xmlns:android="<http://schemas.android.com/apk/res/android>"
        package="com.busanit.myfirstapp">
    
        <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    
        <!-- Other declarations -->
    
    </manifest>
    ```
2. 권한 요청: 앱 실행 중에 권한을 요청한다.
    ```kotlin
    import android.Manifest
    import android.content.pm.PackageManager
    import androidx.core.app.ActivityCompat
    import androidx.core.content.ContextCompat
    
    class MainActivity : AppCompatActivity() {
    
        private val LOCATION_PERMISSION_REQUEST_CODE = 1
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
    
            // 위치 권한 요청
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
    
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE)
            }
        }
    
        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // 권한이 승인된 경우
                    // 위치 정보를 얻는 코드 작성
                    Toast.makeText(this, "위치 권한이 승인되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    // 권한이 거부된 경우
                    Toast.makeText(this, "위치 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    ```
   
## :pushpin: 대표적인 안드로이드 시스템 권한
1. 위치 권한(Location Permissions)
    - `ACCESS_FINE_LOCATION` : GPS를 통해 정확한 위치 정보를 접근할 수 있는 권한
    - `ACCESS_COARSE_LOCATION` : Wi-Fi 및 기지국 정보를 통해 대략적인 위치 정보를 접근할 수 있는 권한
2. 카메라 권한(Camera Permissions)
    - `CAMERA` : 카메라 하드웨어에 접근하여 사진 및 비디오를 촬영할 수 있는 권한
3. 연락처 권한(Contacts Permissions)
    - `READ_CONTACTS` : 사용자의 연락처 데이터를 읽을 수 있는 권한
    - `WRITE_CONTACTS` : 사용자의 연락처 데이터를 수정할 수 있는 권한
    - `GET_ACCOUNTS` : 기기에 등록된 계정 목록에 접근할 수 있는 권한
4. 전화 권한(Phone Permissions)
    - `READ_PHONE_STATE` : 전화 상태와 관련된 정보를 읽을 수 있는 권한
    - `CALL_PHONE` : 전화를 걸 수 있는 권한
    - `READ_CALL_LOG` : 전화 기록을 읽을 수 있는 권한
    - `WRITE_CALL_LOG` : 전화 기록을 수정할 수 있는 권한
    - `ADD_VOICEMAIL` : 음성 메일을 추가할 수 있는 권한
    - `USE_SIP` : SIP 통화를 사용할 수 있는 권한
    - `PROCESS_OUTGOING_CALLS` : 발신 전화를 처리할 수 있는 권한
5. 저장소 권한(Storage Permissions)
    - `READ_EXTERNAL_STORAGE` : 외부 저장소의 파일을 읽을 수 있는 권한
    - `WRITE_EXTERNAL_STORAGE` : 외부 저장소의 파일을 쓸 수 있는 권한
6. 마이크 권한(Microphone Permissions)
    - `RECORD_AUDIO` : 마이크를 통해 오디오를 녹음할 수 있는 권한
7. SMS 권한(SMS Permissions)
    - `SEND_SMS` : SMS 메시지를 보낼 수 있는 권한
    - `RECEIVE_SMS` : SMS 메시지를 받을 수 있는 권한
    - `READ_SMS` : SMS 메시지를 읽을 수 있는 권한
    - `RECEIVE_WAP_PUSH` : WAP 푸시 메시지를 받을 수 있는 권한
    - `RECEIVE_MMS` : MMS 메시지를 받을 수 있는 권한
8. 캘린더 권한(Calendar Permissions)
    - `READ_CALENDAR` : 사용자의 캘린더 데이터를 읽을 수 있는 권한
    - `WRITE_CALENDAR` : 사용자의 캘린더 데이터를 수정할 수 있는 권한
9. 센서 권한(Sensors Permissions)
    - `BODY_SENSORS` : 심박수와 같은 신체 센서 데이터를 접근할 수 있는 권한
10. 위치에 따른 네트워크 상태 권한(Network State Permissions)
    - `ACCESS_NETWORK_STATE` : 네트워크 연결 상태를 확인할 수 있는 권한
    - `ACCESS_WIFI_STATE` : Wi-Fi 연결 상태를 확인할 수 있는 권한
    - `CHANGE_WIFI_STATE` : Wi-Fi 연결 상태를 변경할 수 있는 권한
11. 기타 권한(Other Permissions)
    - `INTERNET` : 인터넷에 접근할 수 있는 권한
    - `BLUETOOTH` : 블루투스 연결을 사용할 수 있는 권한
    - `BLUETOOTH_ADMIN` : 블루투스 설정을 변경할 수 있는 권한
    - `NFC` : NFC 하드웨어에 접근할 수 있는 권한
    - `VIBRATE` : 장치를 진동시킬 수 있는 권한
    - `WAKE_LOCK` : CPU가 슬립 모드로 들어가지 않도록 할 수 있는 권한

## :pushpin: 공식 문서 참조
- [Permissions Overview](https://developer.android.com/guide/topics/permissions/overview)
- [Requesting Permissions at Run Time](https://developer.android.com/training/permissions/requesting)
- [Manifest.permission](https://developer.android.com/reference/android/Manifest.permission)

# ▨ 토스트(Toast) ▨
## :pushpin: 개요
- 토스트 : 사용자가 명시적으로 닫지 않아도 자동으로 사라지는 짧은 메시지
- 주로 간단한 알림이나 상태를 사용자에게 알려주는 데 사용된다.

## :pushpin: 사용 방법
- 기본 토스트 : `Toast.makeText(Context, String, int).show()`
- 위치 변경 : `Toast.setGravity(int, int, int)`
- 커스텀 토스트 : 사용자 정의 레이아웃 사용

## :pushpin: 예제 코드
```kotlin
// 기본 토스트
Toast.makeText(this, "Hello, World!", Toast.LENGTH_SHORT).show()

// 짧은 시간 동안 메시지 표시
Toast.makeText(this, "짧은 시간 동안 표시됩니다.", Toast.LENGTH_SHORT).show()

// 긴 시간 동안 메시지 표시
Toast.makeText(this, "긴 시간 동안 표시됩니다.", Toast.LENGTH_LONG).show()

// 위치 변경
val toast = Toast.makeText(this, "위치가 변경된 토스트입니다.", Toast.LENGTH_SHORT)
toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
toast.show()

// 커스텀 토스트
val inflater = layoutInflater
val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container))
val customToast = Toast(applicationContext)
customToast.duration = Toast.LENGTH_SHORT
customToast.view = layout
customToast.show()
```

## :pushpin: 참고 자료
- [Toast 공식 문서](https://developer.android.com/guide/topics/ui/notifiers/toasts)

# ▨ 스낵바(Snackbar) ▨
## :pushpin: 개요
- 스낵바 : 화면 하단에 표시되는 메시지
- 사용자에게 간단한 알림을 제공하거나 액션을 수행할 수 있는 버튼을 포함할 수 있다.
- 토스트보다 더 많은 기능과 상호작용을 제공한다.

## :pushpin: 사용 방법
- 기본 스낵바 : `Snackbar.make(View, String, int).show()`
- 액션 추가 : `Snackbar.setAction(String, View.OnClickListener)`
- 스타일 변경 : `Snackbar.setActionTextColor(int)` 및 `Snackbar.view.setBackgroundColor(int)`
- 커스텀 스낵바 : 사용자 정의 레이아웃 사용

## :pushpin: 예제 코드
```kotlin
// 기본 스낵바
Snackbar.make(findViewById(R.id.root_layout), "Hello, Snackbar!", Snackbar.LENGTH_SHORT).show()

// 액션 추가
val snackbar = Snackbar.make(findViewById(R.id.root_layout), "메시지 삭제", Snackbar.LENGTH_LONG)
snackbar.setAction("취소") {
    Toast.makeText(this, "삭제 취소됨", Toast.LENGTH_SHORT).show()
}
snackbar.show()

// 스타일 변경
val styledSnackbar = Snackbar.make(findViewById(R.id.root_layout), "스타일 변경된 스낵바", Snackbar.LENGTH_SHORT)
styledSnackbar.setAction("확인") { }
styledSnackbar.setActionTextColor(Color.YELLOW)
styledSnackbar.view.setBackgroundColor(Color.BLUE)
styledSnackbar.show()

// 커스텀 스낵바 (커스텀 레이아웃)
val customSnackbar = Snackbar.make(findViewById(R.id.root_layout), "", Snackbar.LENGTH_LONG)
val customView = layoutInflater.inflate(R.layout.custom_snackbar, null)

// 기존 텍스트와 액션을 제거하고 커스텀 레이아웃을 설정
val snackbarLayout = customSnackbar.view as Snackbar.SnackbarLayout
snackbarLayout.setPadding(0, 0, 0, 0)
snackbarLayout.addView(customView, 0)
customSnackbar.show()
```

## :pushpin: 참고 자료
- [Snackbar 공식 문서](https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar)

# ▨ 다이얼로그(대화상자, Dialog) ▨
## :pushpin: 개요
- 다이얼로그 : 사용자가 상호작용할 수 있는 팝업 창
- 정보를 제공하거나 사용자로부터 입력을 받을 수 있으며, 다양한 종류의 다이얼로그가 있다.

## :pushpin: 종류 및 사용 방법
- `AlertDialog` : 간단한 메시지나 선택지를 제공
- `DatePickerDialog` : 날짜를 선택할 수 있는 다이얼로그
- `TimePickerDialog` : 시간을 선택할 수 있는 다이얼로그
- `ProgressDialog` : 진행 상태를 표시 (Deprecated)
- `Custom Dialog` : 사용자 정의 레이아웃을 사용하는 다이얼로그

## :pushpin: 예제 코드
```kotlin
// AlertDialog
val alertDialogBuilder = AlertDialog.Builder(this)
alertDialogBuilder.setTitle("경고")
alertDialogBuilder.setMessage("이 작업을 수행하시겠습니까?")
alertDialogBuilder.setPositiveButton("예") { dialog, which ->
    Toast.makeText(applicationContext, "예를 선택했습니다.", Toast.LENGTH_SHORT).show()
}
alertDialogBuilder.setNegativeButton("아니오") { dialog, which ->
    Toast.makeText(applicationContext, "아니오를 선택했습니다.", Toast.LENGTH_SHORT).show()
}
alertDialogBuilder.show()

// DatePickerDialog
val calendar = Calendar.getInstance()
val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
    val selectedDate = "$year-${month + 1}-$day"
    Toast.makeText(this, "선택된 날짜: $selectedDate", Toast.LENGTH_SHORT).show()
}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
datePickerDialog.show()

// TimePickerDialog
val timePickerDialog = TimePickerDialog(this, { _, hour, minute ->
    val selectedTime = "$hour:$minute"
    Toast.makeText(this, "선택된 시간: $selectedTime", Toast.LENGTH_SHORT).show()
}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)
timePickerDialog.show()

// Custom Dialog(커스텀 레이아웃)
val customDialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
val customDialog = AlertDialog.Builder(this)
    .setView(customDialogView)
    .create()

customDialogView.findViewById<Button>(R.id.button).setOnClickListener {
    val inputText = customDialogView.findViewById<EditText>(R.id.editText).text.toString()
    Toast.makeText(this, "입력된 값: $inputText", Toast.LENGTH_SHORT).show()
    customDialog.dismiss()
}
customDialog.show()
```

## :pushpin: 참고 자료
- [Dialogs 공식 문서](https://developer.android.com/guide/topics/ui/dialogs)

# ▨ 링톤(Ringtone) ▨
## :pushpin: 개요
- 링톤(Ringtone) : 장치의 기본 알림 소리를 재생하는 기능
- 이를 통해 사용자에게 중요한 알림을 소리로 전달할 수 있다.

## :pushpin: 설정 방법
- 링톤을 재생하려면 `RingtoneManager` 클래스를 사용한다.
- 알림 소리의 URI를 가져와 `Ringtone` 객체를 생성하고, 이를 재생한다.

## :pushpin: 코드 예제
```kotlin
// 링톤을 재생하는 메서드입니다.
private fun playRingtone() {
    val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) // 기본 알림 소리의 URI를 가져옵니다.
    val ringtone = RingtoneManager.getRingtone(applicationContext, soundUri) // 알림 소리를 재생하는 Ringtone 객체를 생성합니다.
    ringtone.play() // 알림 소리를 재생합니다.
}
```

## :pushpin: 주요 포인트
- `RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)`을 사용하여 기본 알림 소리의 URI를 가져온다.
- `RingtoneManager.getRingtone(context, uri)`을 사용하여 `Ringtone` 객체를 생성한다.
- `ringtone.play()`를 호출하여 알림 소리를 재생한다.

# ▨ 진동(Vibrator) ▨
## :pushpin: 개요
- 진동(Vibrator) : 장치의 진동 기능을 활용하여 사용자에게 알림을 전달하는 기능
- 이를 통해 소리 없이도 중요한 알림을 전달할 수 있다.

## :pushpin: 설정 방법
- 진동을 발생시키려면 `Vibrator` 클래스를 사용한다.
- API 레벨에 따라 `VibratorManager`나 `Vibrator`를 사용하여 진동을 설정할 수 있다.

## :pushpin: 코드 예제
```kotlin
// 진동을 발생시키는 메서드입니다.
private fun vibratePhone() {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val manager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager // VibratorManager를 가져옵니다.
        manager.defaultVibrator // 기본 진동기를 가져옵니다.
    } else {
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator // Vibrator를 직접 가져옵니다.
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrator.vibrate(
            VibrationEffect.createWaveform(longArrayOf(0, 500, 1000, 500), -1) // 진동 패턴 설정
        )
    } else {
        vibrator.vibrate(longArrayOf(0, 500, 1000, 500), -1) // 진동 패턴 설정
    }
}
```

## :pushpin: 주요 포인트
- API 31 이상에서는 `VibratorManager`를 사용하여 진동기를 가져온다.
- API 26 이상에서는 `VibrationEffect`를 사용하여 진동 효과를 설정한다.
- `vibrator.vibrate(longArrayOf(0, 500, 1000, 500), -1)`를 사용하여 진동 패턴을 설정하고 진동을 발생시킨다.

## :pushpin: 공식 문서
- [RingtoneManager](https://developer.android.com/reference/android/media/RingtoneManager)
- [Ringtone](https://developer.android.com/reference/android/media/Ringtone)
- [Vibrator](https://developer.android.com/reference/android/os/Vibrator)
- [VibrationEffect](https://developer.android.com/reference/android/os/VibrationEffect)
- [VibratorManager](https://developer.android.com/reference/android/os/VibratorManager) (API 31 이상)

# ▨ 알림(Notification) ▨
## :pushpin: 알림 만드는 순서
1. 알림 채널 생성 (API 26 이상)
    - 알림을 표시하기 위해서는 먼저 알림 채널을 생성해야 한다.
    - `NotificationChannel` 객체를 생성하고, 이를 `NotificationManager`를 통해 등록한다.
2. 알림 생성
    - `NotificationCompat.Builder`를 사용하여 알림을 생성한다.
    - 알림의 아이콘, 제목, 내용, 우선 순위 등을 설정한다.
3. 알림 표시
    - `NotificationManagerCompat`를 사용하여 알림을 표시한다.
    - `notify` 메서드를 호출하여 알림을 표시한다.
4. 권한 요청 (API 33 이상)
    - **`POST_NOTIFICATIONS`** 권한을 요청해야 한다.
    - **`ActivityResultContracts.RequestPermission`**을 사용하여 권한을 요청한다.

## :pushpin: 채널의 함수
- `createNotificationChannel(channel: NotificationChannel)`:
  - `NotificationManager` 클래스의 메서드로, 알림 채널을 생성한다.
- `deleteNotificationChannel(channelId: String)`:
  - 지정된 ID의 알림 채널을 삭제한다.
- `getNotificationChannel(channelId: String)`:
  - 지정된 ID의 알림 채널을 반환한다.
- `getNotificationChannels()`:
  - 모든 알림 채널의 목록을 반환한다.

## :pushpin: 알림 구성 요소
- 알림 아이콘 (setSmallIcon):
  - 알림의 아이콘을 설정한다.
  - 예시) `builder.setSmallIcon(R.drawable.ic_notification)`
- 알림 제목 (setContentTitle):
  - 알림의 제목을 설정한다.
  - 예시) `builder.setContentTitle("알림 제목")`
- 알림 내용 (setContentText):
  - 알림의 내용을 설정한다.
  - 예시) `builder.setContentText("이것은 알림 내용입니다.")`
- 알림 우선 순위 (setPriority):
  - 알림의 우선 순위를 설정한다.
  - 예시) `builder.setPriority(NotificationCompat.PRIORITY_DEFAULT)`
- 알림 클릭 시 실행할 인텐트 (setContentIntent):
  - 알림을 클릭했을 때 실행할 인텐트를 설정한다.
  - 예시) `builder.setContentIntent(pendingIntent)`
- 알림 클릭 시 자동 제거 (setAutoCancel):
  - 알림을 클릭했을 때 자동으로 제거되도록 설정한다.
  - 예시) `builder.setAutoCancel(true)`

## :pushpin: 중요도 상수 (Notification Importance Constants)
- 알림의 중요도를 설정하는 데 사용되는 상수
- 중요도에 따라 알림이 사용자에게 표시되는 방식이 달라진다.
- `NotificationManager.IMPORTANCE_DEFAULT`:
    - 기본 중요도
    - 알림 소리가 나며, 상태바에 아이콘이 표시된다.
- `NotificationManager.IMPORTANCE_HIGH`:
    - 높은 중요도
    - 알림 소리가 나며, 헤드업 알림으로 표시된다.
- `NotificationManager.IMPORTANCE_LOW`:
    - 낮은 중요도
    - 알림 소리가 나지 않으며, 상태바에만 아이콘이 표시된다.
- `NotificationManager.IMPORTANCE_MIN`:
    - 최소 중요도
    - 알림 소리가 나지 않으며, 상태바에도 아이콘이 표시되지 않는다.
- `NotificationManager.IMPORTANCE_MAX`:
    - 매우 높은 중요도
    - 알림 소리가 나며, 전체 화면 알림으로 표시될 수 있다.

## :pushpin: 코드 예제
1. `AndroidManifest.xml` 권한 추가
```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>

```
2. 코드
```kotlin
// 알림 채널을 생성하는 메서드입니다.
private fun createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // API 26 이상에서만 NotificationChannel을 설정합니다.
        val channelId = "default_channel_id" // 채널 ID를 설정합니다.
        val channelName = "Default Channel" // 채널 이름을 설정합니다.
        val channelDescription = "This is the default channel for notifications" // 채널 설명을 설정합니다.
        val importance = NotificationManager.IMPORTANCE_DEFAULT // 채널의 중요도를 설정합니다.
        val channel = NotificationChannel(channelId, channelName, importance).apply {
            description = channelDescription // 채널 설명을 설정합니다.
        }

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager // NotificationManager를 가져옵니다.
        notificationManager.createNotificationChannel(channel) // NotificationChannel을 생성합니다.
    }
}

// 알림을 생성하고 표시하는 메서드입니다.
private fun showNotification() {
    val channelId = "default_channel_id" // 알림 채널 ID를 설정합니다.
    val intent = Intent(this, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // 인텐트 플래그를 설정합니다.
    }
    val pendingIntent = TaskStackBuilder.create(this).run {
        addNextIntentWithParentStack(intent) // 인텐트를 스택에 추가합니다.
        getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE) // PendingIntent를 생성합니다.
    }

    val builder = NotificationCompat.Builder(this, channelId)
        .setSmallIcon(R.drawable.ic_notification) // 알림 아이콘을 설정합니다.
        .setContentTitle("알림 제목") // 알림 제목을 설정합니다.
        .setContentText("이것은 알림 내용입니다.") // 알림 내용을 설정합니다.
        .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 알림의 우선 순위를 설정합니다.
        .setContentIntent(pendingIntent) // 알림 클릭 시 실행할 인텐트를 설정합니다.
        .setAutoCancel(true) // 알림 클릭 시 자동으로 제거되도록 설정합니다.

    with(NotificationManagerCompat.from(this)) {
        notify(1, builder.build()) // 알림을 표시합니다.
    }
}
```
- 권한 요청 코드
```kotlin
// 권한 요청을 위한 ActivityResultLauncher를 등록합니다.
val permissionLauncher = registerForActivityResult(
    ActivityResultContracts.RequestPermission()
) { isGranted: Boolean ->
    if (isGranted) {
        showNotification() // 권한이 허용된 경우 알림을 표시합니다.
    } else {
        Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show() // 권한이 거부된 경우 토스트 메시지를 표시합니다.
    }
}

// 버튼 클릭 리스너를 설정합니다.
binding.button.setOnClickListener {
    // 알림 권한이 있는지 확인합니다.
    if (ContextCompat.checkSelfPermission(
            this,
            "android.permission.POST_NOTIFICATIONS"
        ) == PackageManager.PERMISSION_GRANTED) {
        showNotification() // 권한이 허용된 경우 알림을 표시합니다.
    } else {
        permissionLauncher.launch("android.permission.POST_NOTIFICATIONS") // 권한이 허용되지 않은 경우 권한을 요청합니다.
    }
}
```

## :pushpin: 공식 문서 링크
- Notifications Overview: [Notifications Overview](https://developer.android.com/guide/topics/ui/notifiers/notifications)
- NotificationCompat.Builder: [NotificationCompat.Builder](https://developer.android.com/reference/androidx/core/app/NotificationCompat.Builder)
- NotificationManager: [NotificationManager](https://developer.android.com/reference/android/app/NotificationManager)
- NotificationChannel: [NotificationChannel](https://developer.android.com/reference/android/app/NotificationChannel)

# ▨ Jetpack 라이브러리 ▨
## :pushpin: Jetpack 라이브러리
- Jetpack은 안드로이드 앱 개발을 단순화하고 고품질 앱을 쉽게 만들 수 있도록 도와주는 라이브러리 모음
- 코드의 재사용성을 높이고, 보일러플레이트 코드를 줄이며, 앱의 성능과 안정성을 향상시킨다.
- androidx 네임스페이스는 Android Jetpack 라이브러리로 구성된다.
- androidX의 모든 패키지는 androidx라는 문자열로 시작하는 일관된 네임스페이스에 있다.
- androidx 네임스페이스에 있는 라이브러리는 지원 라이브러리와 마찬가지로 Android 플랫폼과 별도로 제공되며 Android 출시 버전 전체에서 이전 버전과 호환된다.

## :pushpin: 기본
- AppCompat : 하위 호환성을 제공하여 최신 안드로이드 기능을 모든 버전에서 사용할 수 있게 한다.
- Android KTX : 코틀린을 위한 확장 기능을 제공하여 코틀린 코드의 가독성과 생산성을 향상시킨다.

## :pushpin: UI
- ConstraintLayout : 복잡한 레이아웃을 간단하게 정의할 수 있다.
- Fragmen t: 모듈화된 UI 컴포넌트를 구현한다.
- RecyclerView : 대량의 데이터를 효율적으로 표시한다.
- ViewPager2 : 스와이프로 넘기는 화면을 구성한다.
- Drawerlayout : 옆에서 서랍처럼 열리는 화면을 구성한다.
- 기타 많은 기능을 지원

## :pushpin: Jetpack 라이브러리의 이점
1. 생산성 향상 : 보일러플레이트 코드를 줄이고, 개발 속도를 높인다.
2. 품질 향상 : 테스트 가능하고, 유지 보수하기 쉬운 코드를 작성할 수 있다.
3. 안정성 향상 : 다양한 안드로이드 버전에서 일관된 동작을 보장한다.
4. 최신 기술 : 최신 안드로이드 기능과 디자인 패턴을 쉽게 도입할 수 있다.

## :pushpin: 참고 자료
- [Android Jetpack 공식 문서](https://developer.android.com/jetpack)
- [Jetpack 컴포넌트 개요](https://developer.android.com/jetpack/androidx)

# ▨ 안드로이드 테마 설정 ▨
## :pushpin: 안드로이드 테마 설정
- 테마는 앱의 전체적인 룩앤필을 정의하는 중요한 요소
- 색상, 글꼴, 스타일 등을 지정하여 일관된 디자인을 유지할 수 있다.

## :pushpin: 테마 설정 방법
1. 기본 테마 정의 : `res/values/styles.xml` 파일에서 기본 테마를 정의
```xml
<resources>
    <!-- Base application theme -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
</resources>
```
2. 색상 정의 : `res/values/colors.xml` 파일에서 테마에 사용할 색상을 정의
```xml
<resources>
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
    <color name="colorBackground">#FFFFFF</color>
    <color name="colorText">#000000</color>
</resources>
```
3. 테마 적용 : `AndroidManifest.xml` 파일에서 정의한 테마를 앱에 적용
```xml
<application>
    android:theme="@style/AppTheme"
    ... >
    ...
</application>
```

## :pushpin: 커스텀 테마 추가
1. 새로운 테마 정의 : `res/values/styles.xml` 파일에 커스텀 테마를 추가
```xml
<resources>
    <!-- Custom theme -->
    <style name="CustomTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="android:windowBackground">@color/colorBackground</item>
        <item name="android:textColor">@color/colorText</item>
    </style>
</resources>
```
2. 액티비티에 커스텀 테마 적용 : 특정 액티비티에 커스텀 테마를 적용하려면 `AndroidManifest.xml` 파일에서 해당 액티비티에 테마를 지정
```xml
<activity android:name=".CustomActivity"
    android:theme="@style/CustomTheme">
    ...
</activity>
```

## :pushpin: 테마 컬러 항목
1. `colorPrimary`
- 적용 위치 : 앱의 주요 색상으로, 주로 앱 바(Action Bar), 툴바(Toolbar), 상태바(Status Bar) 등에 사용
- 예시) 앱 바의 배경색, 버튼의 기본 색상 등
2. `colorPrimaryDark`
- 적용 위치 : 앱의 주요 색상이 좀 더 어두운 색상으로, 주로 상태바(Status Bar)와 일부 앱 바(Toolbar)의 배경색으로 사용
- 예시) 상태바의 배경색, 앱 바의 어두운 변형.
3. `colorAccent`
- 적용 위치 : 강조 색상으로, 앱 내의 중요한 인터랙티브 요소에 사용
- 버튼, 스위치, 체크박스, 프로그레스 바 등의 강조 색상으로 사용
- 예시) 버튼의 강조 색상, 스위치의 활성화 색상, 체크박스의 체크 색상 등.
4. `android:windowBackground`
- 적용 위치 : 앱의 기본 배경 색상으로, 모든 액티비티와 창의 배경색으로 사용
- 예시) 액티비티의 기본 배경 색상, 팝업 창의 배경 색상 등.
5. `android:textColor`
- 적용 위치 : 앱의 기본 텍스트 색상으로, 모든 텍스트 뷰(TextView), 버튼(Button) 등의 기본 텍스트 색상으로 사용
- 예시) TextView의 텍스트 색상, 버튼의 텍스트 색상 등.

## :pushpin: 참고 자료
- [Android Developers - Styles and Themes](https://developer.android.com/guide/topics/ui/look-and-feel/themes)
- [Material Design - Color](https://material.io/design/color)

# ▨ App Bar ▨
## :pushpin: App Bar
- AppBar : 앱의 상단에 위치하며, 주로 앱의 제목, 네비게이션 아이콘, 메뉴 등을 포함하는 영역
- ActionBar : 안드로이드에서 기본적으로 제공되는 상단 바 컴포넌트로, AppCompatActivity에 의해 자동으로 관리된다.
  - Activity의 상태 및 주요 기능을 사용자에게 제공하는 역할을 한다.
  - 제목과 부제목 표시 : 현재 화면의 제목과 부제목을 설정할 수 있다.
  - 네비게이션 아이콘 : 뒤로 가기 또는 홈으로 이동하는 아이콘을 추가할 수 있다.
  - 액션 아이템(메뉴 아이템) : 자주 사용하는 기능을 빠르게 접근할 수 있도록 메뉴를 추가할 수 있다.
- Toolbar : AppBar의 구체적인 구현체로, 앱의 상단 바 역할
  - 더 유연하고 커스터마이징이 가능하여 XML 레이아웃 파일에 직접 추가할 수 있다.

## :pushpin: 설정
1. AppCompatActivity 사용 : `AppCompatActivity`를 상속하는 액티비티를 사용하여 Action Bar를 설정
2. 테마 설정 : `res/values/styles.xml` 파일에서 앱의 테마를 설정
```xml
<resources>
    <!-- Base application theme -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
</resources>
```
3. 레이아웃 파일 설정 : `res/layout/activity_main.xml` 파일을 생성하거나 수정
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <!-- 다른 UI 요소들을 추가 -->
    
</LinearLayout>
```
4.  액티비티에서 Action Bar 설정 : `MainActivity.kt` 파일에서 Action Bar를 설정하고 커스터마이징
```kotlin
package com.busanit.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Action Bar 설정
        supportActionBar?.apply {
            title = "메인 화면" // Action Bar 제목 설정
            subtitle = "서브 타이틀" // Action Bar 부제목 설정
            setDisplayHomeAsUpEnabled(true) // 네비게이션 아이콘 설정
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24) // 네비게이션 아이콘 커스터마이징
        }
    }
}
```

## :pushpin: 메뉴 항목 추가 및 처리
1. 메뉴 리소스 파일 생성 : `res/menu/menu_main.xml` 파일을 생성
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/action_settings"
        android:title="Settings"
        android:showAsAction="never"/>
    <item
        android:id="@+id/action_favorite"
        android:icon="@drawable/ic_baseline_favorite_24"
        android:title="Favorite"
        android:showAsAction="ifRoom"/>
</menu>
```
- 메뉴 : 메뉴 항목은 사용자가 특정 작업을 수행할 수 있도록 하는 인터페이스 요소로, 메뉴 항목은 보통 액션 바(Action Bar) 또는 툴바(Toolbar)에 표시된다.
- `showAsAction` 속성
    1. `never` : 메뉴 항목을 항상 오버플로우 메뉴(더보기 메뉴)에 표시한다.
    2. `ifRoom` : 메뉴 항목을 공간이 있을 경우 액션 바나 툴바에 표시하고, 공간이 부족하면 오버플로우 메뉴에 표시한다.
    3. `always` : 항상 액션 바나 툴바에 메뉴 항목을 표시한다. 이 옵션은 남용되지 않아야 하며, 주로 중요한 액션에만 사용해야 한다.
    4. `withText` : 아이콘과 함께 텍스트를 표시한다. 이 옵션은 `ifRoom` 또는 `always`와 함께 사용된다.
    5. `collapseActionView` : 메뉴 항목이 액션 뷰를 확장 및 축소할 수 있도록 하며, 주로 검색이나 기타 액션 뷰에 사용된다.
2. 메뉴 인플레이트 : `___Activity.kt` 파일에서 메뉴를 인플레이트하고 항목 클릭 이벤트를 처리
```kotlin
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
        R.id.action_settings -> {
            // 설정 메뉴 클릭 처리
            true
        }
        R.id.action_favorite -> {
            // 즐겨찾기 메뉴 클릭 처리
            true
        }
        android.R.id.home -> {
            // 네비게이션 아이콘 클릭 처리
            finish() // 현재 액티비티 종료
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
```

## :pushpin: 참고 자료
- [Android Developers : Menus 추가](https://developer.android.com/develop/ui/views/components/menus?hl=ko)
- [Android ActionBar 사용 가이드](https://developer.android.com/guide/topics/ui/actionbar)
- [Material Design의 App Bar](https://material.io/components/app-bars-top)

# ▨ 액티비티(Activity) ▨
## :pushpin: 액티비티(Activity)
- Activity는 안드로이드 앱의 화면을 구성하는 기본 단위
- 각 Activity는 사용자와 상호작용하는 단일 화면을 나타낸다.

## :pushpin: Activity 생명 주기(Life Cycle)
- Activity는 여러 상태를 거치며, 각각의 상태 전환 시 특정 콜백 메서드가 호출된다. → Activity 생명 주기
- 생명 주기를 이해하면 효율적으로 리소스를 관리하고 앱의 상태를 제어할 수 있다.

## :pushpin: 주요 생명 주기 메서드
1. `onCreate()`
    - Activity가 처음 생성될 때 호출된다.
    - 초기화 작업을 수행
    - 예시) UI 설정, 데이터 바인딩
2. `onStart()`
    - Activity가 사용자에게 보이기 시작할 때 호출된다.
3. `onResume()`
    - Activity가 사용자와 상호작용하기 직전에 호출된다.
4. `onPause()`
    - 다른 Activity가 시작되려 할 때 호출된다.
    - 데이터 저장 등 필요한 작업을 수행한다.
5. `onStop()`
    - Activity가 더 이상 사용자에게 보이지 않을 때 호출된다.
6. `onDestroy()`
    - Activity가 소멸되기 직전에 호출된다.

## :pushpin: 참고 자료
- ![Activity 생명주기](https://developer.android.com/images/activity_lifecycle.png)

# ▨ 인텐트(Intent) ▨
## :pushpin: 인텐트(Intent)
- 인텐트(Intent) : 안드로이드 컴포넌트 간에 작업을 수행하도록 요청하는 메시지 객체
- 인텐트는 주로 액티비티(Activity)를 시작하거나, 서비스(Service)를 시작하거나, 브로드캐스트(Broadcast)를 전송할 때 사용된다.

## :pushpin: 주요 역할
- 액티비티 전환 : 인텐트를 통해 다른 액티비티를 시작할 수 있다.
- 데이터 전달 : 인텐트를 통해 데이터(문자열, 숫자 등)를 다른 컴포넌트로 전달할 수 있다.
- 외부 앱 호출 : 인텐트를 통해 다른 앱을 호출할 수 있다.
  - 예시) 웹 브라우저를 열거나 연락처 앱을 실행할 수 있다.

## :pushpin: 명시적 인텐트와 암시적 인텐트
- 명시적 인텐트 (Explicit Intent)
  - 명시적 인텐트는 특정 컴포넌트를 명시적으로 지정하여 작업을 요청한다.
  - 주로 앱 내부에서 액티비티를 전환할 때 사용된다.
  - 예시)
    ```kotlin
    // 명시적 인텐트를 사용하여 SecondActivity 시작
    val intent = Intent(this, SecondActivity::class.java)
    startActivity(intent)
    ```
- 암시적 인텐트 (Implicit Intent)
  - 암시적 인텐트는 요청할 작업의 일반적인 정보를 제공하고, 이를 처리할 수 있는 컴포넌트를 시스템이 선택한다.
  - 주로 외부 앱과의 통신이나 특정 작업을 수행할 수 있는 앱을 호출할 때 사용된다.
  - 예시) 
    ```kotlin
    // 암시적 인텐트를 사용하여 웹 브라우저에서 URL 열기
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("<https://www.example.com>"))
    startActivity(intent)
    ```

# ▨ 컨텍스트(Context) ▨
## :pushpin: 컨텍스트(Context)
- 컨텍스트(Context) : 안드로이드 애플리케이션의 중요한 클래스 중 하나로, 애플리케이션의 환경 정보를 제공하는 인터페이스
- 애플리케이션의 다양한 리소스, 애플리케이션 전역의 정보 및 특정 작업을 수행할 수 있는 기능을 제공한다.

## :pushpin: Context의 종류
1. Application Context
    - 애플리케이션의 수명 주기와 동일한 Context
    - 애플리케이션 전역에서 사용할 수 있으며, 일반적으로 애플리케이션의 수명 동안 유지된다.
2. Activity Context
    - 특정 액티비티의 수명 주기와 동일한 Context
    - Activity가 파괴되면 이 Context도 함께 파괴된다.
3. Service Context
    - 특정 서비스의 수명 주기와 동일한 Context

## :pushpin: Context의 주요 역할
1. 리소스 접근 : 앱의 리소스에 접근할 수 있도록 한다.(예: 문자열, 이미지, 레이아웃 등)
2. 애플리케이션 레벨 작업 수행 : 애플리케이션 레벨의 작업을 수행하는 데 사용된다.(시작, 중지 서비스, 브로드캐스트 수신 등)
3. 앱 컴포넌트 관리 : 애플리케이션의 컴포넌트(Activity, Service, BroadcastReceiver, ContentProvider)에 대한 정보와 접근을 제공한다.
4. 시스템 서비스 접근 : 시스템 서비스(WINDOW_SERVICE, LAYOUT_INFLATER_SERVICE 등)에 접근할 수 있도록 한다.

## :pushpin: Context의 주요 메서드
- 리소스 접근
  - `getResources()` : 앱의 리소스에 접근한다.
  - `getString(R.string.example)` : 문자열 리소스를 가져온다.
  - `getDrawable(R.drawable.example)` : `drawable` 리소스를 가져온다.
- 애플리케이션 레벨 작업
  - `startActivity(Intent)` : 새로운 액티비티를 시작한다.
  - `startService(Intent)` : 서비스를 시작한다.
  - `stopService(Intent)` : 서비스를 중지한다.
  - `sendBroadcast(Intent)` : 브로드캐스트를 보낸다.

## :pushpin: 자주 사용하는 암시적 Intent 상수들
| 상수 (Constant)                  | 설명 (Description)                                     |
|----------------------------------|--------------------------------------------------------|
| `Intent.ACTION_VIEW`             | 주어진 URI에 대한 데이터를 보기          |
| `Intent.ACTION_SEND`             | 데이터를 다른 애플리케이션으로 보내기     |
| `Intent.ACTION_SENDTO`           | 특정 주소로 이메일을 보내기             |
| `Intent.ACTION_PICK`             | 데이터를 선택하기                      |
| `Intent.ACTION_DIAL`             | 전화 다이얼을 열기                     |
| `Intent.ACTION_CALL`             | 직접 전화를 걸기(권한 필요)             |
| `Intent.ACTION_EDIT`             | 데이터를 편집하기                      |
| `Intent.ACTION_DELETE`           | 데이터를 삭제하기                      |
| `Intent.ACTION_GET_CONTENT`      | 사용자에게 데이터를 선택하도록 허용              |
| `Intent.ACTION_IMAGE_CAPTURE`    | 카메라 앱을 열어 사진을 찍기            |
| `Intent.ACTION_VIDEO_CAPTURE`    | 카메라 앱을 열어 동영상을 찍기          |
| `Intent.ACTION_VIEW_DOWNLOADS`   | 다운로드한 파일을 보기                 |
| `Intent.ACTION_APPLICATION_DETAILS_SETTINGS` | 앱의 설정 화면을 열기        |
| `Intent.ACTION_SETTINGS`         | 설정 화면을 열기                       |
| `Intent.ACTION_WEB_SEARCH`       | 웹 검색을 시작하기                     |

# ▨ Intent와 ActivityResult ▨
## :pushpin: 인텐트를 사용하여 데이터 전달하기
- 개념 설명 : 인텐트(Intent)는 안드로이드 컴포넌트 간에 작업을 요청하거나 데이터를 주고받는 메시지 객체
  - 데이터 전달을 위해 `putExtra` 메서드를 사용하여 인텐트에 데이터를 추가하고, `getStringExtra` 등의 메서드를 사용하여 데이터를 수신한다.
- 인텐트를 사용하여 데이터 전달하는 방법
  1. 데이터 추가: `putExtra` 메서드를 사용하여 데이터를 인텐트에 추가
  2. 인텐트 시작: `startActivity` 메서드를 사용하여 인텐트를 시작
  3. 데이터 수신: 수신 측에서는 `getStringExtra` 등의 메서드를 사용하여 데이터를 수신
- 데이터 전달의 주요 메서드
| 메서드                      | 설명                                                          |
|-----------------------------|---------------------------------------------------------------|
| `putExtra(String, value)`   | 인텐트에 추가 데이터를 넣습니다.                              |
| `getStringExtra(String)`    | 전달된 문자열 데이터를 수신합니다.                            |
| `getIntExtra(String, int)`  | 전달된 정수형 데이터를 수신합니다.                            |
| `getBooleanExtra(String, boolean)` | 전달된 불린형 데이터를 수신합니다.                    |

## :pushpin: 인텐트를 사용하여 결과 받기
- 개념 설명
  - 다른 액티비티를 시작하고, 그 액티비티가 종료된 후 결과를 받기 위해 `startActivityForResult` 메서드를 사용한다.
  - 결과는 `onActivityResult` 메서드에서 처리한다.
  - 새로운 방법으로는 Activity Result API를 사용하여 결과를 처리할 수 있다.
- 인텐트를 사용하여 결과 받는 방법
  1. 인텐트 시작: `startActivityForResult` 메서드를 사용하여 인텐트를 시작하고 요청 코드를 지정
  2. 결과 처리: 호출된 액티비티에서 `setResult` 메서드를 사용하여 결과를 설정
  3. 결과 수신: 호출한 액티비티에서는 `onActivityResult` 메서드를 오버라이드하여 결과를 처리
- 결과 반환의 주요 메서드
| 메서드                            | 설명                                                               |
|-----------------------------------|--------------------------------------------------------------------|
| `startActivityForResult(Intent, int)` | 인텐트를 시작하고 결과를 요청합니다.                              |
| `setResult(int, Intent)`          | 결과를 설정합니다. (RESULT_OK 또는 RESULT_CANCELED)                  |
| `onActivityResult(int, int, Intent)` | 요청 코드, 결과 코드, 데이터를 수신하여 결과를 처리합니다.         |

## :pushpin: Activity Result API
- 개념 설명
  - Activity Result API는 `startActivityForResult`와 `onActivityResult`를 대체하여 결과를 처리한다.
  - 이 API는 요청 코드가 필요 없으며, 결과 처리 로직을 인텐트를 시작하는 곳에 가까이 두어 코드의 가독성과 유지 보수성을 높인다.
- Activity Result API 사용 방법
  1. ActivityResultContract: 어떤 종류의 인텐트를 보낼지와 그에 따른 결과를 정의
  2. ActivityResultLauncher: 인텐트를 시작하고 결과를 처리
- Activity Result API의 주요 클래스와 인터페이스
| 클래스/인터페이스                          | 설명                                                                   |
|--------------------------------------------|------------------------------------------------------------------------|
| `ActivityResultContract`                   | 인텐트와 그 결과를 정의하는 계약 인터페이스입니다.                       |
| `ActivityResultLauncher`                   | 인텐트를 시작하고 결과를 처리하는 런처입니다.                            |
| `registerForActivityResult(Contract, Callback)` | 계약과 콜백을 등록하여 ActivityResultLauncher를 초기화합니다.           |

## :pushpin: 자주 사용하는 ActivityResultContract
- ActivityResultContracts는 다양한 기본 계약을 제공한다.
| ActivityResultContract                     | 설명                                                               |
|--------------------------------------------|--------------------------------------------------------------------|
| `ActivityResultContracts.StartActivityForResult` | 기본 인텐트를 사용하여 결과를 반환합니다.                              |
| `ActivityResultContracts.RequestPermission` | 특정 권한을 요청하고 그 결과를 반환합니다.                              |
| `ActivityResultContracts.TakePicture`      | 카메라를 사용하여 사진을 찍고 그 결과를 반환합니다.                     |
| `ActivityResultContracts.PickContact`      | 연락처를 선택하고 그 결과를 반환합니다.                              |

## :pushpin: Activity Result API의 차이점
- 간결함: `onActivityResult` 메서드를 오버라이드하지 않아도 되므로 코드가 간결해진다.
- 명확성: 결과 처리 로직이 인텐트를 시작하는 곳과 가까워져 코드의 가독성이 좋아진다.
- 유지 보수성: 각 결과 처리를 독립적으로 구성할 수 있어 코드 유지 보수가 용이하다.

## :pushpin: 참고 자료
- [안드로이드 개발자 공식 문서: Intent와 Intent Filters](https://developer.android.com/guide/components/intents-filters)
- [안드로이드 개발자 공식 문서: 액티비티 결과 처리](https://developer.android.com/training/basics/intents/result)
- [안드로이드 개발자 공식 문서: Activity Result API](https://developer.android.com/training/basics/intents/result)

# ▨ 액티비티 스택(Activity Stack) ▨
## :pushpin: 액티비티 스택(Activity Stack)
- 액티비티 스택은 LIFO(Last In, First Out) 구조로, 안드로이드 시스템에서 액티비티를 관리하는 방법
- 새로운 액티비티가 시작될 때마다 스택의 맨 위에 추가되고, 뒤로 가기(Back) 버튼을 누르면 스택의 맨 위에 있는 액티비티가 제거된다.

## :pushpin: 스택의 동작 방식
1. 새로운 액티비티 시작 : `startActivity()` 메서드를 호출하면 새로운 액티비티가 시작되고 스택의 맨 위에 추가된다.
2. 현재 액티비티 일시 중지 : 새로운 액티비티가 시작되면 현재 액티비티는 일시 중지 상태(Paused)가 된다.
3. 현재 액티비티 종료 : `finish()` 메서드를 호출하면 현재 액티비티가 종료되고 스택에서 제거된다.
4. 뒤로 가기 버튼 : 사용자가 뒤로 가기 버튼을 누르면 스택의 맨 위에 있는 액티비티가 제거되고, 그 아래에 있는 액티비티가 다시 활성화된다.

## :pushpin: 인텐트 플래그(Intent Flags)
- `FLAG_ACTIVITY_NEW_TASK` : 새로운 태스크(Task)에서 액티비티를 시작한다.
- `FLAG_ACTIVITY_CLEAR_TOP` : 스택의 위에 있는 액티비티들을 제거하고 지정된 액티비티를 최상단으로 가져온다.
- `FLAG_ACTIVITY_SINGLE_TOP` : 스택의 최상단에 동일한 액티비티가 이미 존재하는 경우, 새로운 인스턴스를 생성하지 않고 기존 인스턴스를 재사용한다.

## :pushpin: 태스크(Task)와 백스택(Back Stack)
- 태스크는 사용자 작업의 논리적인 단위로, 여러 액티비티로 구성될 수 있다.
  - 예시) 이메일 작성, 전송, 확인 등의 작업이 하나의 태스크를 구성할 수 있다.
- 백스택은 액티비티 스택의 또 다른 표현으로, 사용자가 이전에 방문한 액티비티의 기록을 담고 있어 사용자가 뒤로 가기 버튼을 눌렀을 때 이전 액티비티로 돌아갈 수 있게 한다.

# ▨ RecyclerView ▨
## :pushpin: RecyclerView 개념 정리 표
| 항목                | 설명                                                                                      |
|-------------------------|-----------------------------------------------------------------------------------------------|
| RecyclerView        | 데이터를 효율적으로 표시하고 스크롤 성능을 최적화하기 위해 설계된 리스트 뷰.                         |
| Adapter             | 데이터를 ViewHolder에 바인딩하는 역할.                                                           |
| ViewHolder          | 각 데이터 항목의 뷰를 보유하는 역할.                                                            |
| LayoutManager       | 데이터 항목의 배치를 관리.                                                                     |
| ItemDecoration      | RecyclerView 항목 사이에 간격을 추가하거나 구분선을 그리는 등의 장식을 추가하는 클래스.                 |
| LayoutManager 종류  | LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager.                          |
| 클릭 이벤트 처리    | 항목 클릭 이벤트를 처리하려면 ViewHolder에 클릭 리스너를 추가.                                      |
| ItemDecoration 종류 | 기본 제공 DividerItemDecoration, 커스텀 ItemDecoration.                                       |

## :pushpin: RecyclerView 구성 요소
| 구성 요소       | 역할 및 설명                                                                                  |
|---------------------|--------------------------------------------------------------------------------------------------|
| RecyclerView    | 데이터를 효율적으로 표시하기 위한 컨테이너 뷰.                                                    |
| Adapter         | 데이터를 개별 ViewHolder에 바인딩하는 역할.                                                       |
| ViewHolder      | 각 항목의 뷰를 보유하고 재사용을 관리.                                                            |
| LayoutManager   | RecyclerView 내의 항목 배치를 관리.                                                               |
| ItemDecoration  | 항목 간의 간격, 구분선 등 추가적인 장식을 관리.                                                   |

## :pushpin: LayoutManager 종류
| LayoutManager               | 설명                                                                                       |
|---------------------------------|----------------------------------------------------------------------------------------------|
| LinearLayoutManager         | 세로 또는 가로 방향의 리스트를 만듭니다.                                                       |
| GridLayoutManager           | 그리드 형태의 레이아웃을 만듭니다.                                                           |
| StaggeredGridLayoutManager  | 불규칙한 크기의 항목을 가진 그리드 레이아웃을 만듭니다.                                      |

## :pushpin: ItemDecoration
| ItemDecoration 종류         | 설명                                                                                       |
|---------------------------------|----------------------------------------------------------------------------------------------|
| DividerItemDecoration       | 기본 구분선 ItemDecoration.                                                                   |
| 커스텀 ItemDecoration       | 개발자가 정의한 간격이나 구분선을 추가.                                                      |

## :pushpin: RecyclerView 설정 예제
| 설정 단계               | 설명 및 코드 예제                                                                         |
|-----------------------------|---------------------------------------------------------------------------------------------|
| 레이아웃 파일에 추가     | `res/layout/activity_main.xml` 파일에 RecyclerView 추가.                                       |
| 데이터 모델 생성         | 데이터를 표현할 간단한 모델 클래스 생성 (`Item.kt`).                                            |
| ViewHolder와 Adapter 생성| RecyclerView 항목을 보유하고 데이터를 바인딩하는 클래스 생성 (`ItemAdapter.kt`).                    |
| 아이템 레이아웃 파일 생성| 각 항목의 레이아웃 정의 (`res/layout/item_layout.xml`).                                         |
| RecyclerView 설정        | `MainActivity.kt` 파일에서 RecyclerView 설정 및 Adapter 연결.                                    |
| ItemDecoration 추가      | `MainActivity.kt` 파일에서 기본 구분선 또는 커스텀 간격 추가.                                    |

## :pushpin: RecyclerView 설정 예제 코드
- `dependencies` 추가
```kotlin
dependencies {
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}
```
- `activity_main.xml`
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
    
</LinearLayout>
```
- `Item.kt`
```kotlin
package com.example.myapp

data class Item(val title: String)
```
- `ItemAdapter.kt`
```kotlin
package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.titleTextView.text = item.title
    }

    override fun getItemCount() = items.size
}
```
- `item_layout.xml`
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/item_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        />
    
</LinearLayout>
```
- MainActivity.kt
```kotlin
package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 샘플 데이터 생성
        val items = listOf(
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
            Item("Item 5")
        )

        // RecyclerView 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ItemAdapter(items)

        // DividerItemDecoration 추가
        val dividerItemDecoration = DividerItemDecoration(binding.recyclerView.context, LinearLayoutManager.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
    }
}
```

# ▨ ViewPager2 & TabLayout ▨
## :pushpin: ViewPager2 & TabLayout
- 개념 
  - TabLayout과 ViewPager2는 안드로이드에서 탭 기반 네비게이션을 구현할 때 사용되는 두 가지 주요 구성 요소
  - TabLayout은 탭을 통해 여러 화면을 전환할 수 있는 사용자 인터페이스를 제공하고, ViewPager2는 사용자가 스와이프 제스처를 통해 여러 페이지를 탐색할 수 있도록 한다.
- 주요 개념
  - TabLayout : 사용자가 선택할 수 있는 탭의 집합을 제공
    - 탭은 일반적으로 상단에 위치하며, ViewPager2와 연동하여 화면 전환을 관리
  - ViewPager2 : RecyclerView 기반의 새로운 ViewPager로, 여러 페이지를 스와이프를 통해 전환할 수 있게 한다.
    - FragmentStateAdapter를 통해 각 페이지에 해당하는 Fragment를 관리
  - FragmentStateAdapter : ViewPager2와 함께 사용되며, 각 페이지에 해당하는 Fragment를 생성하고 관리

## :pushpin: ViewPager2 주요 메서드
| 메서드/속성                  | 설명                                                        |
|------------------------------|-------------------------------------------------------------|
| `setAdapter(Adapter adapter)` | ViewPager2에 어댑터를 설정합니다.                           |
| `setCurrentItem(int item)`    | 현재 보여줄 페이지를 설정합니다.                             |
| `getCurrentItem()`            | 현재 보여지는 페이지의 인덱스를 반환합니다.                  |
| `setOrientation(int orientation)` | 페이지 스와이프 방향을 설정합니다. (HORIZONTAL or VERTICAL) |
| `registerOnPageChangeCallback(OnPageChangeCallback callback)` | 페이지 변경 콜백을 등록합니다. |

## :pushpin: TabLayout, FragmentStateAdapter, TabLayoutMediator 주요 메서드
| 구성 요소        | 주요 메서드/속성              | 설명                                                         |
|------------------|------------------------------|-------------------------------------------------------------|
| TabLayout        | `addTab(Tab tab)`            | TabLayout에 새로운 탭을 추가합니다.                         |
| FragmentStateAdapter | `createFragment(int position)` | 주어진 위치에 해당하는 Fragment를 생성합니다.               |
| TabLayoutMediator | `TabLayoutMediator(...)`     | TabLayout과 ViewPager2를 연동합니다.                        |
| TabLayoutMediator | `attach()`                   | TabLayout과 ViewPager2의 연동을 적용합니다.                 |

## :pushpin: 공식 문서
- [ViewPager2로 프래그먼트 간 슬라이드](https://developer.android.com/develop/ui/views/animations/screen-slide-2?hl=ko)

# ▨ Retrofit 라이브러리 ▨
## :pushpin: Retrofit
- Retrofit은 Square에서 개발한 HTTP 클라이언트 라이브러리로
- 안드로이드 및 자바에서 RESTful API를 쉽게 사용할 수 있도록 도와준다.
- Retrofit을 사용하면 HTTP 요청을 보다 간결하고 직관적으로 작성할 수 있으며, 네트워크 통신을 비동기적으로 처리할 수 있다.
- Retrofit은 JSON 데이터를 자동으로 파싱하여 자바 객체로 변환해주는 편리한 기능 제공

## :pushpin: 주요 기능 및 장점
- 간편한 HTTP 요청 작성 : 인터페이스 선언을 통해 HTTP 요청을 정의할 수 있다.
- 자동 데이터 변환 : Gson, Jackson 등의 라이브러리를 이용해 JSON 데이터를 자동으로 파싱하여 객체로 변환한다.
- 비동기 처리 : 네트워크 요청을 비동기적으로 처리하여 UI 스레드가 블록되지 않도록 한다.
- 확장성 : OkHttp, RxJava, Coroutine 등 다양한 라이브러리와 쉽게 통합할 수 있다.

## :pushpin: 공식 문서
- [Retrofit 공식 사이트](https://square.github.io/retrofit/)

## :pushpin: 순서
1. Retrofit 라이브러리 설치
   - Retrofit을 사용하기 위해서는 먼저 프로젝트의 `build.gradle` 파일에 Retrofit 및 관련 의존성을 추가
```gradle
// build.gradle (app level)
dependencies {
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}
```
2. 데이터 클래스 정의
   - API 응답을 매핑할 데이터 클래스를 정의합니다.
   - 예시) `Post`라는 이름의 데이터 클래스를 정의
    ```kotlin
    // Post.kt
    data class Post(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
    )
    ```
3. API 인터페이스 정의
   - `@GET` : GET 요청을 지정하는 어노테이션
   - `@POST` : POST 요청을 지정하는 어노테이션
   - `@PUT` : PUT 요청을 지정하는 어노테이션
   - `@DELETE` : DELETE 요청을 지정하는 어노테이션
   - `@Path` : URL 경로에 변수 삽입
   - `@Query` : URL 쿼리 매개변수 추가
   - `@Body` : 요청 본문에 객체 전달
    ```java
    public interface ApiService {
        @GET("posts")
        Call<List<Post>> getPosts();  // 모든 포스트를 가져오는 GET 요청
    
        @GET("posts/{id}")
        Call<Post> getPostById(@Path("id") int id);  // 특정 ID의 포스트를 가져오는 GET 요청
    
        @POST("posts")
        Call<Post> createPost(@Body Post post);  // 새로운 포스트를 생성하는 POST 요청
    
        @PUT("posts/{id}")
        Call<Post> updatePost(@Path("id") int id, @Body Post post);  // 특정 ID의 포스트를 수정하는 PUT 요청
    
        @DELETE("posts/{id}")
        Call<Void> deletePost(@Path("id") int id);  // 특정 ID의 포스트를 삭제하는 DELETE 요청
    }
    ```

4. Retrofit 인스턴스 생성
   - Retrofit 인스턴스를 생성하고, `ApiService` 인터페이스를 구현하는 객체를 생성
     - `Retrofit.Builder` : Retrofit 인스턴스를 생성하는 빌더 클래스
     - `Base URL` : 기본 URL 설정
     - `ConverterFactory` : JSON 파싱을 위한 컨버터 팩토리 설정(여기서는 Gson 사용)
    ```kotlin
    // RetrofitClient.kt
    object RetrofitClient {
        private const val BASE_URL = "https://api.example.com/"
    
        val instance: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // JSON 변환을 위해 GsonConverterFactory 추가
                .build()
    
            retrofit.create(ApiService::class.java)
        }
    }
    ```
5. Retrofit을 사용한 네트워크 호출
   - `Call` : 네트워크 요청을 나타내는 객체
   - `enqueue` : 비동기 요청 처리 메서드
   - `Callback` : 응답 처리 콜백 인터페이스
    ```java
    ApiService apiService = retrofit.create(ApiService.class);
    
    // GET 요청 예시
    Call<List<Post>> call = apiService.getPosts();
    call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            if (response.isSuccessful()) {
                List<Post> posts = response.body();
                // 응답 데이터 처리
            }
        }
    
        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            // 오류 처리
        }
    });
    ```
6. AndroidManifest.xml 설정
   - 인터넷 권한을 사용하기 위해 `AndroidManifest.xml` 파일에 아래 내용을 추가
    ```xml
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.busanit.androidstudy">
    
        <application
            ...>
            <!-- 인터넷 권한 추가 -->
            <uses-permission android:name="android.permission.INTERNET" />
        </application>
    </manifest>
    ```

## :pushpin: Retrofit의 주요 클래스 및 인터페이스
1. `Call`
   - `Call`은 Retrofit에서 네트워크 요청을 나타내는 인터페이스
   - 요청을 실행하고, 응답을 처리하는 메서드를 제공
   - 메서드
       - `enqueue(Callback<T> callback)`
         - 비동기적으로 요청을 실행
         - 요청이 완료되면 `Callback` 객체의 메서드가 호출
       - `execute()`
         - 동기적으로 요청을 실행
         - 네트워크 요청이 완료될 때까지 호출을 차단(blocking)

   - 예시 코드
    ```kotlin
    interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>> // 네트워크 요청을 나타내는 Call 객체 반환
    }
    ```

2. `Callback`
   - `Callback`은 Retrofit에서 비동기 네트워크 요청의 응답을 처리하기 위한 인터페이스
   - `Call` 객체의 `enqueue` 메서드와 함께 사용
   - 메서드
       - `onResponse(call: Call<T>, response: Response<T>)`
         - 요청이 성공적으로 완료되면 호출
         - `Response` 객체를 통해 응답 데이터를 접근할 수 있음
       - `onFailure(call: Call<T>, t: Throwable)`
         - 요청이 실패하면 호출
         - 실패 원인은 `Throwable` 객체를 통해 확인할 수 있음

   - 예시 코드
    ```kotlin
    val api = RetrofitClient.instance
    api.getPosts().enqueue(object : Callback<List<Post>> {
        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
            if (response.isSuccessful) {
                val posts = response.body()
                // 성공적으로 응답을 받은 경우 처리
            }
        }
    
        override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            // 요청 실패 처리
        }
    })
    ```

3. `Response`
   - `Response`는 Retrofit에서 HTTP 응답을 나타내는 클래스
   - 이 클래스는 응답 데이터와 함께 상태 코드, 헤더 등도 제공
   - 메서드
     - `body()` : 응답 데이터를 반환
     - `code()` : HTTP 상태 코드를 반환
     - `message()` : 상태 코드와 관련된 메시지를 반환합
     - `headers()` : 응답의 헤더를 반환
     - `isSuccessful()` : 응답이 성공적(상태 코드 200~299)인지 여부를 반환

   - 예시 코드
    ```kotlin
    override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
        if (response.isSuccessful) {
            val posts = response.body()
            // 성공적으로 응답을 받은 경우 처리
        } else {
            // 응답은 받았지만 성공적이지 않은 경우 처리
        }
    }
    ```
4. `ConverterFactory`
   - `ConverterFactory`는 Retrofit에서 HTTP 응답을 원하는 형식으로 변환하기 위한 팩토리 패턴 클래스
   - 일반적으로 JSON 데이터를 자바 객체로 변환하는 데 사용
   - GsonConverterFactory
     - Retrofit에서 가장 많이 사용되는 `ConverterFactory` 중 하나
     - Gson을 이용해 JSON 데이터를 자바 객체로 변환
   - 예시 코드
    ```kotlin
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create()) // Gson을 이용한 데이터 변환
        .build()
    ```