package team2.proto.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="refresh_token", nullable = false)
    private String refreshToken;

    @Column(name="expiry_date", nullable = false)
    private Instant expiryDate;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User userId;
}
