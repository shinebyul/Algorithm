import java.util.*;
import java.io.*;

public class Main{
    static int R, C, M;
    
    static int[][] sea; //바다에 상어 번호 표시
    static List<Shark> shark; //상어 정보
    
    public static class Shark{
        boolean isDead = false;
        int r,c;
        int s=0,d=0,z=0;
        public Shark(){}
        public Shark(int r, int c, int s, int d, int z){
            this.r = r; this.c = c;
            this.s = s; this.d = d; this.z = z;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        sea = new int[R+1][C+1]; //바다에 상어 번호 표시
        shark = new ArrayList<>(); //상어 정보
        shark.add(new Shark()); //상어 1번부터 시작하기 위해 임의로 0번 넣어주기
        
        int number = 1; //상어 번호
        
        for(int i=0;i<M;i++){
            //r, c, s 속력, d 방향, z 크기
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            //상어 정보 저장
            shark.add(new Shark(r,c,s,d,z));
            
            //바다에 상어 번호 표시
            sea[r][c]=number++;
        }
        
        int answer = 0;
        
        for(int i=1;i<C+1;i++){
            //상어 낚시
            for(int j=1;j<R+1;j++){
                if(sea[j][i]!=0){
                    Shark s = shark.get(sea[j][i]);
                    s.isDead=true;
                    answer+=s.z;
                    sea[j][i]=0;
                    break;
                }
            }
       
            //상어 이동
            move();
        }
        System.out.println(answer);
    }
    public static void move(){
        int[][] newSea = new int[R+1][C+1];
        
        for(int i=1;i<shark.size();i++){
            Shark s = shark.get(i);
            
            if(s.isDead) continue;
            if(s.z==0) continue;
            
            int row = 0;
            int col = 0;
            
            if(s.d==1){ //up
                col = s.c;
                if(s.s > s.r-1){
                    int count = s.s;
                    count-=s.r-1;
                    int share = count/(R-1);
                    int remain = count%(R-1);
                    
                    if(share%2==0){
                        row = 1+remain;
                        s.d = remain > 0 ? 2 : s.d;
                    }else{
                        row = R-remain;
                        s.d = remain > 0 ? s.d : 2;
                    }
                }else{
                    row = s.r-s.s;
                }
            }else if(s.d==2){ //down
                col = s.c;
                if(s.s > R-s.r){
                    int count = s.s;
                    count-=R-s.r;
                    int share = count/(R-1);
                    int remain = count%(R-1);
                    
                    if(share%2==0){
                        row = R-remain;
                        s.d = remain > 0 ? 1 : s.d;
                    }else{
                        row = 1+remain;
                        s.d = remain > 0 ? s.d : 1;
                    }
                }else{
                    row = s.r+s.s;
                }
            }else if(s.d==3){ //right
                row = s.r;
                if(s.s > C-s.c){
                    int count = s.s;
                    count-=C-s.c;
                    int share = count/(C-1);
                    int remain = count%(C-1);
                    
                    if(share%2==0){
                        col = C-remain;
                        s.d = remain > 0 ? 4 : s.d;
                    }else{
                        col = 1+remain;
                        s.d = remain > 0 ? s.d : 4;
                    }
                }else{
                    col = s.c + s.s;
                }
            }else if(s.d==4){ //left
                row = s.r;
                if(s.s > s.c-1){
                    int count = s.s;
                    count-=s.c-1;
                    int share = count/(C-1);
                    int remain = count%(C-1);
                    
                    if(share%2==0){
                        col = 1+remain;
                        s.d = remain > 0 ? 3 : s.d;
                    }else{
                        col = C-remain;
                        s.d = remain > 0 ? s.d : 3;
                    }
                   
                }else{
                    col = s.c-s.s;
                }
            }
            
            s.r = row;
            s.c = col;
            
            if(newSea[row][col]==0){
                newSea[row][col]=i;
            }else{
                Shark other = shark.get(newSea[row][col]);
                if(s.z > other.z){
                    other.isDead = true;
                    newSea[row][col]=i;
                }else{
                    s.isDead = true;
                }
            }
        }
        sea = newSea;
    } 
}