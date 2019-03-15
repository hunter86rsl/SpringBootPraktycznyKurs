package pl.anikiel.springbootcourse.service;

public interface UserService<T> extends BaseService {

    public void confirmUser(int id);

}
