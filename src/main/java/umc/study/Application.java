package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.domain.UserEntity;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.service.UserMissionService.UserMissionQueryService;
import umc.study.service.UserService.UserQueryService;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			StoreQueryService storeService = context.getBean(StoreQueryService.class);
//
//			// 파라미터 값 설정
//			String name = "요아정";
//			Float score = 4.0f;
//
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			storeService.findStoresByNameAndScore(name, score)
//					.forEach(System.out::println);
//		};
//	}

//	@Bean
//	public CommandLineRunner run1(ApplicationContext context) {
//		return args -> {
//			MissionQueryService missionService = context.getBean(MissionQueryService.class);
//
//			Long userId = 1L;
//			UserMissionStatus userMissionStatus = UserMissionStatus.INPROGRESS;
//
//			System.out.println("------------------------");
//			System.out.println("userId: " + userId);
//			System.out.println("status: " + userMissionStatus);
//
//			missionService.findMissionByUserIdAndUserMissionStatus(userId, userMissionStatus, 2, 1)
//					.forEach(System.out::println);
//		};
//	}

//	@Bean
//	public CommandLineRunner run2(ApplicationContext context) {
//		return args -> {
//			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
//
//			Long userId = 1L;
//			Long storeId = 1L;
//			String content = "서비스가 좋아용";
//			BigDecimal score = BigDecimal.valueOf(4.0);
//
//			System.out.println("------------------------");
//			System.out.println("userId: " + userId);
//			System.out.println("storeId: " + storeId);
//			System.out.println("content: " + content);
//			System.out.println("score: " + score);
//
//			System.out.println(reviewService.writeReview(userId, storeId, content, score));
//		};
//	}

//	@Bean
//	public CommandLineRunner run3(ApplicationContext context) {
//		return args -> {
//			UserMissionQueryService userMissionService = context.getBean(UserMissionQueryService.class);
//
//			Long userId = 1L;
//			Long regionId = 1L;
//			UserMissionStatus userMissionStatusC = UserMissionStatus.COMPLETE;
//			UserMissionStatus userMissionStatusI = UserMissionStatus.INPROGRESS;
//
//			System.out.println("------------------------");
//			System.out.println("userId: " + userId);
//			System.out.println("regionId: " + regionId);
//
//			List<UserMissionEntity> tmp1 = userMissionService.findUserMissionByUserIdAndRegionIdAndUserMissionStatus(userId, regionId, userMissionStatusC, 1, 10);
//			System.out.println("완료 개수 : " + tmp1.size());
//			tmp1.forEach(userMission -> System.out.println(userMission.getMissionEntity()));
//
//
//			List<UserMissionEntity> tmp2 = userMissionService.findUserMissionByUserIdAndRegionIdAndUserMissionStatus(userId, regionId, userMissionStatusI, 1,10);
//			System.out.println("진행중 개수 : " + tmp2.size());
//			tmp2.forEach(userMission -> System.out.println(userMission.getMissionEntity()));
//		};
//	}

//	@Bean
//	public CommandLineRunner run4(ApplicationContext context) {
//		return args -> {
//			UserQueryService userQueryService = context.getBean(UserQueryService.class);
//
//			Long userId = 3L;
//
//			System.out.println("------------------------");
//			System.out.println("userId: " + userId);
//
//			UserEntity userEntity = userQueryService.findUser(userId);
//			System.out.println(userEntity);
//		};
//	}
}