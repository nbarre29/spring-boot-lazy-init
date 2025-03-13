https://www.youtube.com/watch?v=2YC5pIXR7e4 (Spring Boot - @Autowired, @Qualifier, @Primary, @Required | Simple Programming)

GET: http://localhost:8080/autowire

___________________________________________________________________

-> In AutowiredController.java remove @Qualifier("cat")

In Cat.java add @Primary

@Primary
@Service
public class Cat implements  Animal {
    @Override
    public String sound() {
        return "Meow";
    }
}


-> In AutowiredController.java

    @Autowired
    private Animal dog;

    @GetMapping
    public String fetchSound() {
        return dog.sound();
    }
	

-> autowiring by property:  The @Autowired annotation is used to inject the Animal bean into the dog property based on the type. Since there is no @Qualifier specified, Spring will inject the primary bean of type Animal.


a) remove @Primary from Cat.class


b) In AutowiredController.java 

    @Autowired
    private Animal dog;

    @GetMapping
    public String fetchSound() {
        return dog.sound();
    }
	
	
-> Autowiring by Setter

public class AutowiredController {


    // @Autowired    //this should be removed 
    private Animal animal;

    @Autowired
    public void setAnimal(@Qualifier("cat") Animal animal) {
        this.animal = animal;
    }

    @GetMapping
    public String fetchSound() {
        return animal.sound();
    }
}


->  Autowiring by constructor


public class AutowiredController {

    private Animal animal;

    @Autowired
    AutowiredController(@Qualifier("cat") Animal animal) {
        this.animal = animal;
    }

    @GetMapping
    public String fetchSound() {
        return animal.sound();
    }
}

