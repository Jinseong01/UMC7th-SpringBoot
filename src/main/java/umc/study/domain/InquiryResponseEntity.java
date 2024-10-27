package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Table(name = "inquiry_response")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class InquiryResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    // 외래키
    @OneToOne // 1대1 관계
    @JoinColumn(name = "inquiry_id")
    private InquiryEntity inquiryEntity;
}
