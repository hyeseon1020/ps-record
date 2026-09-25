package access.ex;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public void addItem(Item item){
        if (itemCount > items.length){
            System.out.println("장바구니가 가득 찼습니다.");
        }
        items[itemCount] = item;
        itemCount++;
    }

//    public void displayItems(){
//        System.out.println("장바구니 상품 출력");
//        for (Item i : items){
//            System.out.println("상품명: " + i.getName() + ", 합계: " + i.getTotal());
//        } 이렇게 하면 i의 값이 null인 경우가 생겨서 안됨 값은 나오지만 오류남
//    }

    public void displayItems(){
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.println("상품명: " + item.getName() + ", 합계: " + item.getTotal());
        }
        System.out.println("전체 가격 합: " + calculateTotalPrice());
    }

    private int calculateTotalPrice(){
        int totalPrice = 0;
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            totalPrice += item.getTotal();
        }

        return totalPrice;
    }
}
