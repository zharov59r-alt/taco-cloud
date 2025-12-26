package tacos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
@Entity
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taco_order_generator")
    @SequenceGenerator(name = "taco_order_generator", sequenceName = "taco_order_id_seq", allocationSize = 1)
    private Long id;
    private Date placedAt = new Date();;

    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip code is required")
    private String deliveryZip;

  //  @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

  //  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

  //  @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCvv;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> taco = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.taco.add(taco);
    }

}