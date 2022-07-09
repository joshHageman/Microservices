package customer;

import com.hagemanservices.clients.fraud.FraudCheckResponse;
import com.hagemanservices.clients.fraud.FraudClient;
import com.hagemanservices.clients.notification.NotificationClient;
import com.hagemanservices.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final NotificationClient notificationClient;
    private final FraudClient fraudClient;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        notificationClient.CreateNoti(
                new NotificationRequest(customer.getId(), LocalDateTime.now(), "Hello "+ customer.getFirstName(), customer.getEmail())
        );

        if(fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
