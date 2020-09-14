package save_data;

import org.springframework.stereotype.Component;

@Component
@Derby
public class DerbyDao implements Dao {
    @Override
    public void save() {
        System.out.println("Save in Derby");
    }
}
