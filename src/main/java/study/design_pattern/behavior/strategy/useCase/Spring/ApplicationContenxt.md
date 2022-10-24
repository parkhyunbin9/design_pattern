## ApplicationContext

#### 설명  
- SpringContainer -> BeanFactory 인터페이스의 하위 인터페이스.
- BeanFactory + 추가 기능( 국제화, 환경변수 ,리소스 조회, 애플리케이션 이벤트 등)
- 다양한 구현체를 가짐 (@Configuration,@Bean Annotation 기반 / XML기반 등..
다양한 방법으로 스프링 컨테이너 생성)
- 다양한 방식으로 beanDefinition을 추상화 하여 Bean 등록( XML, Annotation.. 등)


>  BEAN은 스프링 컨테이너 내부에 bean저장소에 <bean이름,bean> K,V 로 저장
> 
>  스프링 컨테이너가 bean을 싱글톤으로 관리(= 싱글톤 컨테이너)
                     

#### Spring 과 전략 패턴

스프링 부트를 동작시킬때, SpringApplication 내부를 보면  SpringApplication 인스턴스를 생성할때 ResourceLoader를 통해 주입받는다.

ResourceLoader 인터페이스 설명을 보면 Strateg Interface라고 적혀있다.

> Bean properties of type Resource and Resource[] can be
> populated from Strings when running in an ApplicationContext,
> using the particular context's resource loading strategy.

특정 컨텍스트의 리소스 로딩 전략을 활용해 ApplicationContext가 동작할때 문자열로 된 다양한 리소스들을 bean 객체로 발행해준다.


* 스프링은 다양한 리소스 (XML, Bean, fileSystem )에서 선언 혹은 정의된 내용을 로드하여, bean객체로 생성 스프링 컨테이너 내에서 싱글톤 객체로 관리한다. 

* 상황에 따른 bean 관리 방식이 다르다.

* 따라서 전체 흐름에는 영향을 주지 않고 새로운 리소스 관리 방식 선택하거나 추가 하여 사용할 수 있다.






