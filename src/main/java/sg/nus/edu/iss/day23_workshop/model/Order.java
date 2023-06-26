package sg.nus.edu.iss.day23_workshop.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer orderId;
    private Date orderDate;
    private Integer customerId;
    private Double total;
    private Double costPrice;

}
