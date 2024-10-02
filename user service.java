@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public void saveUser (User user) {
        userRepository.save(user);
    }
}