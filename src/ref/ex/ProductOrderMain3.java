package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args){
        //주문 수량을 입력받기
        //가격, 수량, 상품명을 입력받기
        //이력시 상품 순서를 알 수 있게 "n번째 주문 정보를 입력하세요." 라는 메시지를 출력하기
        //입력이 끝나면 등록한 상품과 총 결제 금액을 출력하기
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int count = scanner.nextInt();

        ProductOrder[] orders = new ProductOrder[count];
        if(count > 0) {
            for (int i = 0; i < count; i++) {
                scanner.nextLine(); //입력 버퍼를 비우기 위한 코드
                System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");

                System.out.print("상품명: ");
                String productName = scanner.nextLine();

                System.out.print("가격: ");
                int price = scanner.nextInt();

                System.out.print("수량: ");
                int quantity = scanner.nextInt();

                orders[i] = createOrder(productName, price, quantity);
            }

            printOrders(orders);

            int totalAmount = getTotalAmount(orders);
            System.out.println("총 결제 금액: " + totalAmount);
        }
    }
    static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder order1 = new ProductOrder();
        order1.productName = productName;
        order1.price = price;
        order1.quantity = quantity;
        return order1;
    }
    static void printOrders(ProductOrder[] orders){
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }
    static int getTotalAmount(ProductOrder[] orders){
        int totalAmount = 0;
        for (ProductOrder order : orders){
            totalAmount += order.price * order.quantity;
        }
        return  totalAmount;
    }
}
