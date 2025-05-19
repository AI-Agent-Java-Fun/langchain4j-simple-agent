package org.example.tool;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс, содержащий тулы для взаимодействия с агентом, при использовании spring-boot стартера
 * методы с аннотацией тулов из бинов добавляются автоматически, поэтому используется аннотация @Component.
 */
@Component
public class DiceTool {

    /**
     * Аннотация @Tool используется для обозначения инструмента, который будет автоматически помещен
     * в запрос к агенту, имя тула будет совпадать с названием метода, если не использовать атрибут
     * name. Описание тула, как можно заметить, добавляется через атрибут value.
     * Для параметров существует необязательная аннотация @P, где добавляется описание параметра и флаг required.
     */
    @Tool(value = "Инструмент для бросание игральных кубиков, который возвращает сумму выпавших очков")
    public Integer rollDice(@P(value = "How many dice to roll") Integer count) {

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += ThreadLocalRandom.current().nextInt(6) + 1;
        }
        return sum;
    }
}
