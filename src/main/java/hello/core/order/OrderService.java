package hello.core.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemId, int itemPrice);

}
