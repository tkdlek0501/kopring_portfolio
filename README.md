# kopring_portfolio
코프링 포트폴리오 - 매장 예약 서비스

**ERD :**
https://www.erdcloud.com/d/tre8espsZqdk2vLYY

<details>
  <summary>기능 정리(정리중)</summary>
1. 어떤 기능이 필요하고, 그 기능이 어떤 목적을 가지는지, 어떻게 사용하는지, 화면에는 어떻게 나와야 하는지, 서버에서는 어떻게 처리하는 지 정리 해본다.

- 필요 기능
    1. StoreController
        
        예약 사용이 가능한 매장을 관리
        
        - 매장 정보 생성, 수정, 조회, 삭제 기능
    2. ScheduleController
        
        예약 스케줄을 관리
        
        - 스케줄 생성, 수정, 조회, 삭제 기능
            - 여기서 말하는 스케줄은 특정 room이 될 수도 있고, 상품이 될 수도 있음
        - 기본 운영 시간 생성, 수정, 조회 , 삭제 기능
        - 부가 설정 기능
            - 당일 예약 설정
            - 브레이크 타임 설정
    3. HolidayController
        
        휴무일 관리 (정기 휴무, 법정 휴무, 선택 휴무)
        
        - 휴무일 추가, 수정, 조회, 삭제 기능
    4. TimeTableController
        
        타임테이블 관리(기본 운영 시간으로 부터 만들어진 타임테이블 관리)
        
        DateTable과 TimeTable 로 관리
        
        DateTable : 일자별 관리, TimeTable : 시간별 관리
        
        - 예약 가능 일자 조회
        - 예약 가능 시간 조회
    5. ReservationController
        
        유저 예약 관리
        
        - 예약 생성, 수정(상태 변경 포함), 조회, 삭제
- 부가 기능
    - 필터?AP?에서 request 이모지 변환 처리
    - request validation
    - custom exception 공통 처리
    - AOP logger
    - JWT
    - Util
- 예약 상태 정리 (네이버 참고)
    
    예약 요청시 자동으로 예약 확정이 되고,
    
    요청된 예약 중 변경을 한다면 이때는 자동 확정이 아니라 매장에서 확인/ 거절해야 한다.
    
    그리고 예약 취소도 자동으로 확정이 된다.
    
    (단, 자동으로 확정이 된다하더라도 validation 필터링은 있다.)
    
    상태)
    
    REQUEST_CONFIRM : 예약 확정
    
    MODIFY_REQUEST : 예약 변경 요청
    
    MODIFY_CONFIRM : 예약 변경 확정
    
    MODIFY_REFUSE : 예약 변경 거절
    
    CANCEL_CONFIRM : 예약 취소 확정
    
    STORE_CANCEL : 매장 예약 취소
    
    NOSHOW : 고객 노쇼; 매장 방문 하지 않는 등에 대한 상태
    
    COMPLETE : 완료; 매장 방문까지 완료하는 등 상태
</details>
