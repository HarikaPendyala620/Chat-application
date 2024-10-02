@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        if (password.equals(confirmPassword)) {
            User user = new User(username, email, password);
            userService.saveUser (user);
            // Registration successful, redirect to login page
            return "redirect:/login";
        } else {
            // Registration failed, display error message
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
    }
}