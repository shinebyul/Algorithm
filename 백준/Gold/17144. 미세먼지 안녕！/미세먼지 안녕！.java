import java.util.*;
import java.io.*;

public class Main{
    public static int[][] room;
    public static int R, C, T;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        //공기청정기 위치
        int[] air = new int[2];
        int index = 0;

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1) air[index++] = i;
            }
        }

        for(int i=0;i<T;i++){
            dust(air);
            windTop(air);
            windBottom(air);
        }

        int sum = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(j==0 && (i==air[0] || i==air[1])) continue; //가습기
                sum+=room[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void dust(int[] air){
        int[][] newRoom = new int[R][C];

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(j==0 && (i==air[0] || i==air[1])) continue; //가습기

                int diff = room[i][j]/5;

                for(int k=0;k<4;k++){
                    int x = j+dx[k];
                    int y = i+dy[k];
                    if(x<0 || x>=C || y<0 || y>=R) continue; //벽
                    if(x==0 && (y==air[0]||y==air[1])) continue; //가습기

                    newRoom[y][x] += diff;
                    newRoom[i][j] -= diff;
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                room[i][j]+=newRoom[i][j];
            }
        }
    }

    public static void windTop(int[] air){
        int x = 1;
        int y = air[0];

        int diff = 0;

        while(x<C){
            int out = room[y][x];
            room[y][x++] = diff;
            diff = out;
        }
        x--;
        y--;
        while(y>=0){
            int out = room[y][x];
            room[y--][x] = diff;
            diff = out;
        }
        y++;
        x--;
        while(x>=0){
            int out = room[y][x];
            room[y][x--] = diff;
            diff = out;
        }
        x++;
        y++;
        while(y<air[0]){
            int out = room[y][x];
            room[y++][x] = diff;
            diff = out;
        }
        
    }

    public static void windBottom(int[] air){
        int x = 1;
        int y = air[1];

        int diff = 0;

        while(x<C){
            int out = room[y][x];
            room[y][x++] = diff;
            diff = out;
        }
        x--;
        y++;
        while(y<R){
            int out = room[y][x];
            room[y++][x] = diff;
            diff = out;
        }
        y--;
        x--;
        while(x>=0){
            int out = room[y][x];
            room[y][x--] = diff;
            diff = out;
        }
        x++;
        y--;
        while(y>air[1]){
            int out = room[y][x];
            room[y--][x] = diff;
            diff = out;
        }
    }


}