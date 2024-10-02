public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}