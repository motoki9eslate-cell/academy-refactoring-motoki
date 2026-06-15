public class UserQueryService {
    private final UserMapper userMapper;

  public List<User> getActiveUsers() {
    List<User> users = userMapper.findAll();
    List<User> result = new ArrayList<>();

    for (User user : users) {
      if (!user.isDeleted()) {
        result.add(user);
      }
    }
    return result;
  }

  public boolean existsByEmail(String email) {
    return userMapper.findByEmail(email) != null;
  }
}
