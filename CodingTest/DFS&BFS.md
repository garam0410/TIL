# **DFS (Depth-First Search)**
- 깊이 우선 탐색

- 깊은 부분을 우선적으로 탐색하는 알고리즘

- 스택 혹은 재귀 함수를 이용

    1. 탐색 시작 노드를 스택에 삽입하고 방문 처리

    2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있다면 그 노드를 스택에 넣고 방문 처리. 방문하지 않은 인접 노드가 없다면 스택에서 최상단 노드를 꺼냄

    3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복

<br><br>

# **BFS (Breadth-First Search)**
- 너비 우선 탐색

- 가까운 노드부터 우선적으로 탐색하는 알고리즘

- 특정 조건에서 최단 경로 문제 해결하는데 사용

- 큐 자료구조 이용

    1. 탐색 시작 노드를 큐에 삽입하고 방문 처리

    2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 주에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리

    3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복

<br><br>

## **문제1.** 음료수 얼려 먹기
N x M 크기의 얼음 틀이 있습니다. 구멍이 뚫려 잇는 부분은 0, 칸막이가 존재하는 부분은 1로 표시 됩니다. 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주합니다. 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오. 다음의 4x5 얼음 틀 예시에서는 아이스크림이 총 3개 생성 됩니다. 

    입력
    4 5
    00110
    00011
    11111
    00000

    출력 : 3

- DFS 활용

    1. 특정한 지점의 주변 상, 하, 좌, 우를 살펴본 뒤에 주변 지점 중에서 값이 '0' 이면서 아직 방문하지 않은 지점이 있다면 해당 지점을 방문한다. 

    2. 방문한 지점에서 다시 상, 하, 좌, 우를 살펴보면서 방문을 진행하는 과정을 반복하면, 연결된 모든 지점을 방문할 수 있다.

    3. 모든 노드에 대하여 1 ~ 2번의 과정을 반복, 방문하지 않은 지점의 수를 카운트 한다.

            public class DFS_ex1 {
                static int n;
                static int m;
                static int[][] graph = {{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}};
                public static void main(String[] args){
                    n = 4;
                    m = 5;

                    int result = 0;

                    for(int i = 0; i<n; i++){
                        for(int j = 0; j<m; j++){
                            //현재 위치에서 DFS 수행
                            if (dfs(i,j)){
                                result +=1;
                            }
                        }
                    }

                    System.out.println(result);
                }

                static boolean dfs(int x, int y){
                    // 범위를 벗어나면 종료
                    if(x<=-1 || y<=-1 || x>=n || y>=m)
                        return false;

                    // 현재 노드를 방문하지 않았다면
                    if(graph[x][y] == 0){
                        // 방문 처리
                        graph[x][y] = 1;

                        //상하좌우위치 재귀 호출
                        dfs(x+1, y);
                        dfs(x-1, y);
                        dfs(x, y+1);
                        dfs(x, y-1);
                        return true;
                    }
                    return false;
                }
            }

## **문제2.** 미로 탈출
동빈이는 N x M 크기의 직사각형 형태의 미로에 갇혔습니다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 합니다.

동빈이의 위치는 (1, 1)이며 미로의 출구는 (N,M)의 위치에 존재하고 한번에 한 칸씩 이동할 수 있습니다. 이 때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있습니다. 미로는 반드시 탈출할 수 있는 형태로 제시됩니다.

이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하세요. 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산합니다.

- 상하좌우로 움직여야하는 문제는 방향 배열을 선언해서 해결

        public class BFS_ex1 {
            static int n = 5;
            static int m = 6;
            static int[][] graph;

            // 상하좌우
            static int[] dx = {-1,1,0,0};
            static int[] dy = {0,0,-1,1};

            public static void main(String[] args){
                graph = new int[][]{{1, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

                System.out.println(bfs(0,0));
            }

            static int bfs(int x, int y){
                Queue<Node> queue = new LinkedList<>();
                // 항목 Queue에 넣기
                queue.offer(new Node(x,y));

                while(!queue.isEmpty()){
                    Node node = queue.poll();
                    x = node.x;
                    y = node.y;

                    // 현재 위치에서 4가지 방향 모두 확인

                    for(int i = 0; i<4; i++){
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        //공간을 벗어난 경우
                        if(nx<0 || ny < 0 || nx >= n || ny >= m) continue;

                        // 벽인 경우에는 무시
                        if(graph[nx][ny] == 0) continue;

                        // 해당 노드를 처음 방문 했을 때만 최단 거리 기록
                        if(graph[nx][ny] == 1){
                            graph[nx][ny] = graph[x][y] + 1;
                            queue.offer(new Node(nx,ny));
                        }
                    }
                }

                return graph[n-1][m-1];
            }
        }

        class Node{
            int x;
            int y;

            public Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }