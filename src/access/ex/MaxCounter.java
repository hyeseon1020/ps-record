package access.ex;

public class MaxCounter {
    private int count;
    private int max;
    //int max 최대값으로 생성자를 통해 입력합니다.
    public MaxCounter(int max){
        this.max = max;
    }
    //increment() 숫자를 하나 증가
    public void increment(){
        if(count >= max){
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        count++;
    }
    //getCount() 지금까지 증가한 값을 반환
    public int getCount(){
        return count;
    }
}
