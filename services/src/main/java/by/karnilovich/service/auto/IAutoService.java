package by.karnilovich.service.auto;

import by.karnilovich.entity.auto.Auto;

import java.time.LocalDate;
import java.util.List;

public interface IAutoService {

    List<Auto> availableCars(LocalDate start, LocalDate end);

    boolean checkAvailability(Auto auto, LocalDate start, LocalDate end);

}
