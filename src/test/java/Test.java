import com.demo.controller.BookController;
import com.demo.dao.BookDAOImpl;
import com.demo.dto.BookDTO;
import com.demo.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        BookDAOImpl dao = new BookDAOImpl();
        List<BookDTO> list = dao.getAllBooks();
    }
}

