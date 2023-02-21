## 최강재

## 콜버스 사전 과제 - 커뮤니티 REST API 개발

### 목차
- [개발 환경](#개발-환경)
- [빌드 및 실행](#빌드-및-실행)
- [구현 기능 요구 사항](#구현-기능-요구-사항)

### 개발 환경
- Java 1.8
- Spring Boot 2.7.8
- Spring MVC, JPA
- MySQL
- Gradle

### 빌드 및 실행

#### 이미지를 통해 직접 빌드

`docker-compose.yml`
```
version: "3.7"

services:
  api:
    image: choikj33/econrich:1.2
    container_name: task_api
    restart: always
    ports:
      - "29888:8080"
    depends_on:
      - db
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - DB_HOST=db
      - DB_USERNAME=user
      - DB_PASSWORD=password
      - DB_PORT=3306
      - DB_DATABASE=hr
      - DB_OPTION=useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&serverTimezone=Asia/Seoul
      - PRIVATE_KEY="${메일을 통해 전달}"

  db:
    container_name: task_db
    image: mysql
    restart: unless-stopped
    environment:
      - MYSQL_ROOT_PASSWORD=root
      - MYSQL_USER=user
      - MYSQL_PASSWORD=password
      - MYSQL_DATABASE=hr
    expose:
      - 3306
    volumes:
      - mysql:/var/lib/mysql

volumes:
  mysql:
```

#### 호스팅 중인 URI 이용

`접속 URI` : [https://hanrabong.asuscomm.com/econrich](https://hanrabong.asuscomm.com/econrich)

##### API 명세서 확인

```
https://hanrabong.asuscomm.com/econrich/swagger-ui/index.html#
```

### 구현 기능 요구 사항

- [x] 특정 사원의 현재 정보 조회 가능한 API 구현
- [x] 특정 사원의 이력 정보 조회 가능한 API 구현
- [x] 부서 및 위치 정보 조회 가능한 API 구현
- [x] 특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 할 수 있는 API 구현
- [x] RDBMS 스키마와 별개로 공공 데이터 포털( www.data.go.kr ) 등에서 임의의 API 선택 후 조회 가능하도록 커스터마이징된 API 구현

