package com.epam.services

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * @author Evgeny Borisov
 */
@Component
class UserProps(@Value("${garbage}") val garbage: java.util.List[String]) extends Serializable {


}
