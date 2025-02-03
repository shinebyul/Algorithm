import java.util.*;

class Solution {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int n;
    static Queue<int[]> q = new LinkedList<>();
    

    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

    static Queue<int[][]> blocks = new LinkedList<>();

    static Comparator<int[]> com = (o1, o2) ->{
        if(o1[0] != o2[0]) return o1[0] - o2[0];
        return o1[1] - o2[1];
    };
    static int answer = 0; 
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        gameboard(game_board);
        block(table);
        game_start();
        return answer;
    }
    public static void game_start(){
        for(ArrayList<int[]> cur : list){ // game_board 빈칸들 
            int size = blocks.size();
            for(int i = 0; i < size; i++){
                int [][] block = blocks.poll();   // 블록 꺼내기 
                if(game_logic(cur, block)) break; // 이번 블록으로 채웠다면 stop
                blocks.add(block);
            }
        }
    }
    public static boolean game_logic(ArrayList<int[]> cur, int [][] block){
         int count = 0;
         int m = block.length; 
         while(count < 4){
             block = rotate(block, count); // 회전 시키기 
             boolean first = true;
             boolean end   = false;
             int size = 0;
             boolean [][] visited = new boolean [m][m];
             for(int i = 0; i < m; i++){
                 for(int j = 0; j < m; j++){
                     if(block[i][j] == 0) continue;
                     ArrayList<int []> temp = new ArrayList<>();
                     visited[i][j] = true;
                     q.add(new int []{i, j});
                     while(!q.isEmpty()){
                         int [] out = q.poll();
                         for(int k = 0; k < 4; k++){
                             int nx = arx[k] + out[0];
                             int ny = ary[k] + out[1];
                             if(0 > nx || 0 > ny || nx >= m || ny >= m) continue;
                             if(visited[nx][ny] || block[nx][ny] == 0) continue;
                             visited[nx][ny] = true;
                             size++;
                             temp.add(new int [] {nx, ny});
                             q.add(new int [] {nx, ny});
                         }
                     }
                     if(temp.size() != cur.size()) return false; // 사이즈가 틀리면 바로 return
                     temp.sort(com); // 똑같은 방식으로 정렬 
                     
                     boolean answer_check = true;
                     for(int k = 0; k < temp.size(); k++){
                         int [] board_get = cur.get(k);
                         int [] block_get = temp.get(k);
                         if(board_get[0] != block_get[0] - i || board_get[1] != block_get[1] - j){
                             answer_check = false;
                             break;
                         }
                     }
                     if(answer_check){
                         answer += cur.size() + 1;
                         return true;
                     }
                     first = false;
                     break;
                 }
                 if(!first) break;
             }
             count++;
         }
         return false;
    }
    public static int [][] rotate(int [][] block, int count){
        if(count == 0) return block;
        int m = block.length;
        int [][] change = new int [m][m];
        for(int i = 0; i < m; i++){
            for(int j = m - 1; j >= 0; j--){
                change[j][m - i - 1] = block[i][j];
            }
        }
        return change;
    }
    public static void block(int [][] table){
        boolean [][] visited = new boolean [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 이미 방문 or 빈칸 skip
                if(visited[i][j] || table[i][j] == 0) continue;
                visited[i][j] = true; // 방문 표시 
                q.add(new int []{i, j}); // 큐에 현재 좌표 삽입
                int max_x = i;
                int max_y = j;
                int min_x = i;
                int min_y = j;
                while(!q.isEmpty()){
                    int [] cur = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = cur[0] + arx[k];
                        int ny = cur[1] + ary[k];
                        // 다음 이동 체크 
                        if(!check(nx, ny) || visited[nx][ny] || table[nx][ny] == 0) continue;
                        visited[nx][ny] = true; // 방문 표시 
                        q.add(new int [] {nx, ny}); // 큐에 추가 
                        max_x = Math.max(max_x, nx);
                        max_y = Math.max(max_y, ny);
                        min_x = Math.min(min_x, nx);
                        min_y = Math.min(min_y, ny);
                    }
                }
                // 모양 찍어내기 
                int max = Math.max(max_x - min_x, max_y - min_y) + 1;
                int [][] output = new int [max][max];
                for(int k = min_x; k <= max_x; k++){
                    for(int l = min_y; l <= max_y; l++){
                        output[k-min_x][l-min_y] = table[k][l];
                    }
                }   
                blocks.add(output);
            }
        }
    }
    public static void gameboard(int [][] gb){
        boolean [][] visited = new boolean [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 이미 방문 or 채워진 칸 skip
                if(visited[i][j] || gb[i][j] == 1) continue;
                ArrayList<int[]> temp = new ArrayList<>();
                visited[i][j] = true; // 방문 표시 
                q.add(new int []{i, j}); // 큐에 현재 좌표 삽입
                while(!q.isEmpty()){
                    int [] cur = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = cur[0] + arx[k];
                        int ny = cur[1] + ary[k];
                        // 다음 이동 체크 
                        if(!check(nx, ny) || visited[nx][ny] || gb[nx][ny] == 1) continue;
                        visited[nx][ny] = true; // 방문 표시 
                        temp.add(new int [] {nx - i, ny - j});
                        q.add(new int [] {nx, ny}); // 큐에 추가 
                    }
                }
                temp.sort(com); // 정렬 
                list.add(temp); // 리스트에 삽입 
            }
        }
    }
    // ArrayIndexOutOfBounds 검사기 
    public static boolean check(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}