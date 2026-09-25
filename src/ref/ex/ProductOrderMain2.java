package ref.ex;

public class ProductOrderMain2 {
    public static void main(String[] args){
        // 여러 상품의 주문정보를 배열로 관리
        ProductOrder[] orders = new ProductOrder[3];
        // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);

        // printOrders()를 사용해서 상품 주문 정보 출력
        printOrders(orders);
        // getTotalAmount()를 사용해서 총 결제 금액 계산
        int total = getTotalAmount(orders);
        // 최종 결제 금액을 계산하여 출력
        System.out.println("총 결재 금액 :" + total);
    }
    //주문정보 담기
    static ProductOrder createOrder(String productName, int price, int quantity){
       ProductOrder  order = new ProductOrder();
       order.productName = productName;
       order.price = price;
       order.quantity = quantity;
       return order;
    }
    //주문정보 출력
    static void printOrders(ProductOrder[] orders){
        for (ProductOrder o : orders) {
            System.out.println("상품명 :" + o.productName + "가격 :" + o.price + "수량 :" + o.quantity);
        }
    }
    //총 결제 금액
    static int getTotalAmount(ProductOrder[] orders){
        int totalAmount = 0;
        for (ProductOrder o : orders){
            totalAmount +=  (o.price * o.quantity);
        }
        return totalAmount;
    }
}
