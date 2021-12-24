# **Spring Security**

## **동작 원리**

<br>

1. **ID, PW 요청**

<br>

2. **AuthenticationFilter가 요청을 받아서 UsernamePasswordAuthenticationToken 생성**
    
        해당 요청을 처리할 수 있는 Provider를 찾는데 사용

    <br>

3. **AuthenticationManager에게 처리 위임**

        AuthenticationManager는 List 형태로 Provider들을 가지고 있음

        Provider들을 차례로 탐색하면서 각 Provider들의 supports 메소드 확인

    <br>

4. **Token을 처리할 수 있는 Authentication Provider 선택**

        support 메소드를 호출하여 처리가능한 Provider 선택

    <br>

5. **UserDetailsService의 loadUserByUsername 메소드 수행**

        loadUserByUsername 오버라이딩

        해당 메소드 안에서 사용자를 찾는 로직 구현

        없다면 예외처리도 진행

    <br>

6. **사용자의 정보가 저장된 곳(DB)에서 데이터를 꺼내서 UserDetails 형태로 반환**

<br>

7. **인증 완료 시, Authentication 객체를 SecurityContextHolder 안에 저장**

<br>

---

## **사용되는 객체**

<br>

- **Authentication Filter**

        사용자의 요청을 받아 인증에 사용되는 UsernamePasswordToken을 생성해주는 Filter

<br>

- **UsernamePasswordAuthenticationToken**

        AuthenticationFilter에 의해 생성된 객체

        로그인을 시도한 ID, PW의 데이터를 가지고 있음

<br>

- **AuthenticatonManager**

        authenticate라는 인증 메소드를 제공

<br>

- **ProviderManager**

        AuthenticationManager를 구현하는 객체

        authenticate를 오버라이딩

        authenticate 메소드 안에서 멤버로 갖고있는 Provider를 순회
        
        UsernamePasswordAuthenticationToken을 처리할 수 있는 Provider를 찾아서 요청 위임

<br>

- **AuthenticationProvider**

        supports 메소드를 통해 해당 Token 객체를 처리할 수 있는지 확인

        처리할 수 있는 경우 내부의 authenticate 메소드를 통해 인증 처리


<br>

- **UserDetailsService**

        사용자 정보를 찾는데 사용되는 loadUserByUsername 메소드를 제공하는 인터페이스

        이를 구현하는 클래스는 loadUserByUsername을 오버라이딩

        username으로 사용자 정보를 찾는 로직 구현

<br>

- **UserDetails**

        Spring Security에서 관리하는 사용자 정보

        직접 구현해도되고, UserDetails를 따로 User에서 구현해도 됨


<br>

- **SecurityContextHolder**

        SecurityContext를 저장하는 객체

<br>

- **SecurityContext**

        현재 인증된 사용자의 정보(Authentication)를 저장하는데 사용