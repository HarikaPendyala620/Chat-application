@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userService.findByUsernameAndPassword(username, password);
        if (user != null) {
            // Login successful, redirect to chat page
            return "redirect:/chat";
        } else {
            // Login failed, display error message
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}