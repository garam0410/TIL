# **gRPC**

## **사전지식**

<br>

## **RPC**

<br>

    1. Remote Procedure Call의 약자

    2. 한 프로그램이 네트워크의 세부 정보를 이해하지 않고도 네트워크 안의
    다른 컴퓨터에 있는 프로그램에서 서비스를 요청하는 프로토콜

    3. Client-Server 모델 사용

    4. Client에서 서비스를 요청하면, Server에서 서비스 제공

<br>

## **HTTP**

<br>

    1. TCP/IP Protocol의 Application Layer에서 동작

    2. HTTP 프로토콜은 stateless v로토콜

    3. 상태가 없다는 것은 데이터를 주고 받기위한 각각의 요청이 서로 독립적으로 관리됨을 의미

    4. 이전의 데이터 요청과 다음 데이터 요청이 관련 없음

<br>

**HTTP 1.1**

    1. 연결당 하나의 Request와 하나의 Response를 처리

    2. 동시전송 문제와 다수의 리소스 처리에 속도 및 성능 이슈 존재

        - HOLB(Head Of Line Blocking) : 특정 응답 지연

            첫 응답이 지연되면 다음 응답에 대한 대기시간도 무한정 증가
        
        - RTT(Round Trip Time) 증가

            하나의 연결에 하나의 Request를 처리

            즉, 하나의 연결마다 TCP 연결을 진행

            신뢰성 연결을 하는 TCP는 시작시 3way, 종료시 4way handshake 반복 발생
            (오버헤드 발생)

        - Heavy Header

            1.1 버전의 Header에는 metadata 저장

            사용자가 방문한 웹페이지는 다수의 HTTP Request 발생

            이 경우, 매 Request 마다 중복된 Header를 전송, cookie가 큰 문제

<br>

**HTTP 2.0**

    1.1 버전과 동일한 API 이면서 성능향상에 초점
    
        - Multiplexed Streams

            하나의 연결로 동시에 여러개의 메시지 주고받기 가능

            Response는 순서에 상관 없이 Stream으로 주고 받음

        - Stream Prioritization

            리소스간 우선순위를 설정해 Client 가 먼저 필요한 리소스 부터 보내줌

        - Server Push

            Server는 Client의 요청에 대해 요청하지 않은 리소스를 맘대로 보낼 수 있음

        - Header Compression

            Header 압축

## **IDL**

<br>

    Interface Definitaion Language

    Server, Client의 정보를 주고받는 규칙 = 프로토콜

    IDL은 정보를 저장하는 규칙

    XML, JSON, Protocol Buffers(proto) 존재

<br>

**Protocol Buffers(proto)**

    1. XML의 문제점을 개선하기 위해 제안

    2. 구조화된 데이터를 직렬화 하기위한 프로토콜

    3. XML 스키마 처럼 *.proto 파일에 Protocol Buffer 메세지 타입 정의

    장점

        - 간단함

        - 파일크기가 3배에서 10배 정도 작음

        - 속도가 20배에서 100배 정도 빠름

        - XML보다 가독성이 좋고 명시적

<br>

---

<br>

## **gRPC**

<br>

    1. google에서 만든 RPC 플랫폼

    2. Protocol Buffer와 RPC 사용

    3. proto3 사용

    4. SSL/TLS 사용하여 Server 인증 및 Client와 Server간에 교환되는 모든 데이터 암호화

    5. HTTP 2.0 사용하여 성능이 뛰어나고 확장 가능한 API 제공

    6. Client Application을 Server에서 함수로 바로 호출 가능
        -> 분산 MSA를 쉽게 구현

<br>