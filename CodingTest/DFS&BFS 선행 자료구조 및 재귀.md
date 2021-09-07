# **DFS/BFS**

- 탐색 : 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정

- 대표적인 그래프 탐색 알고리즘으로 DFS/BFS 가 있음

-  **코딩 테스트에서 매우 자주 등장하는 유형**

<br>

## **알아야 할 자료구조**
<br>

### 스택(Stack)
- 먼저 들어 온 데이터가 나중에 나가는 형식(First In Last Out) 자료구조

- 입구와 출구가 동일한 형태로 시각화 할 수 있음

- 삽입(push), 삭제(pop)

<br>

### 큐(Queue)
- 먼저 들어 온 데이터가 먼저 나가는 형식(First In First Out) 자료구조
- 입구와 출구가 모두 뚫려 있는 터널과 같은 형태로 시각화 할 수 있음
- 삽입(offer), 삭제(poll)

<br>

## **재귀 함수(Recursive Function)**
- 자기 자신을 다시 호출하는 함수

- 재귀 함수를 문제 풀이에서 사용할 때는 재귀 함수의 종료 조건을 반드시 명시해야 함

- 그렇지 않으면 함수가 무한히 호출될 수 있음

- 스택에 넣었다가 차례대로 pop 하는 것과 같은 모습

<br>

    1. 재귀 함수를 잘 활용하면 복잡한 알고리즘을 간결하게 작성할 수 있지만, 다른 사람이 이해하기 어려운 코드가 될 수도 있으므로 신중하게 사용

    2. 모든 재귀 함수는 반복문을 이용하여 동일한 기능을 구현

    3. 재귀 함수가 반복문보다 유리한 경우도 있고 불리한 경우도 있음

    4. 컴퓨터가 함수를 연속적으로 호출하면 컴퓨터 메모리 내부의 스택 프레임에 쌓임

        => 스택을 사용해야 할 때 구현상 스택 라이브러리 대신에 재귀 함수를 이용하는 경우가 많음

<br>

### 팩토리얼
    n! = 1 x 2 x 3 x ... x (n-1) x n

<br>

    public class Factorial {
        public static void main(String[] args){
            System.out.println(factorial_iterative(5));
            System.out.println(factorial_recursive(5));
        }

        //단순 반복문
        static int factorial_iterative(int n){
            int answer = 1;

            for(int i = 1; i<n+1; i++){
                answer *= i;
            }

            return answer;
        }

        //재귀 이용
        static int factorial_recursive(int n){
            if(n==1) return 1;

            int answer = n * factorial_recursive(n-1);

            return answer;
        }
    }

<br>

### 유클리드 호제법(최대공약수 계산)
- 두 개의 자연수에 대한 최대 공약수를 구하는 대표적인 알고리즘

- 두 자연수 A, B에 대하여(A>B) A를 B로 나눈 나머지를 R이라고 할 때, A와 B의 최대 공약수는 B와 R의 최대 공약수와 같다.

- 그대로 재귀함수로 작성 가능

        public class GCD {
            public static void main(String[] args){
                System.out.println(gcd(192,162));
            }

            static int gcd(int a, int b){
                // 나누어 떨어지면, b 리턴
                if(a % b == 0) return b;
                else
                    // a와 b의 최대 공약수 gcd(a,b) 는 a를 b로 나눈 나머지(a%b) 와 b의 최대공약수와 같다 gcd(b, a%b)
                    return gcd(b, a%b);
            }
        }