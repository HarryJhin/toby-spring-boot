# [인프런] 토비의 스프링 부트 - 이해와 원리 학습

스프링 부트는 스프링을 더 쉽게 사용할 수 있도록 도와주는 프레임워크이다.

스프링은 매우 유연한 프레임워크이기 때문에, 사용자가 원하는 방식으로 많은 부분을 커스터마이징할 수 있다. 
하지만 이러한 유연성은 사용자가 스프링을 사용하기 위해 많은 설정을 해야 한다는 단점을 가지고 있다. 
이러한 단점을 해결하기 위해 스프링 부트는 스프링의 기본 설정을 미리 해두고, 사용자가 원하는 설정만 추가하면 된다는 방식을 채택하고 있다.

## 1. 스프링 부트 시작하기

1. spring-boot-cli 설치
    ```shell
    sdk install springboot 3.2.1
    ```
2. spring boot 프로젝트 생성
    ```shell
    spring init -b 3.2.1 -d web -g blog.harryjhin -l java -j 17 -n toby-spring-boot -x
    ```

## 2. 개발 환경

- MacOS: Sonoma
- IDE: IntelliJ IDEA Ultimate
- JDK: Java 17 (Amazon Corretto)
- TEST: HTTPie
