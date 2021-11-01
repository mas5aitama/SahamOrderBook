package com.SahamOrderBook.apps.controller


import com.SahamOrderBook.apps.entity.User
import com.SahamOrderBook.apps.repository.UserRepository
import com.SahamOrderBook.apps.response.ResponseHandler
import com.SahamOrderBook.apps.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.net.URI


@RestController
@RequestMapping("api")
class UserController(private val userRepository: UserRepository, private  val userService: UserService) {

    @PostMapping(value= ["/regist"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun setProfilePicture(@PathVariable  @RequestParam file: MultipartFile): ResponseEntity<Any>{
        return try{
            val user = User()
            val id = user.id
            if (id != null) {
                userService.setProfilePicture(id, file)
            }
            ResponseEntity
                .created(URI("/api/user/${id}/profile-picture"))
                .build()
        }catch(error: NoSuchElementException){
            ResponseEntity
                .notFound()
                .build()
        }

    }


/*

    @GetMapping(value = ["/user"])
    fun getAllSaham(): ResponseEntity<Any> {
        return try {
            val result: List<User> = userRepository.findAll()
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result, countTbl)

        } catch (e: Exception) {
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Dont Have Data", countTbl)
        }
    }
*/

    @PostMapping("/register",consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun createUser(@PathVariable user: User, file: MultipartFile, passwordEncoder: Argon2PasswordEncoder): ResponseEntity<Any> {
        return try {
           /* val picture = ClassPathResource("image/Angular.png")
            var arrayPic = ByteArray(picture.contentLength().toInt())
            picture.inputStream.read(arrayPic)*/

            val result = userRepository.save(user)
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse("Save! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Email Already Exist", countTbl)
        }
    }

   /* @PostMapping(value = ["/saveProduct"])
    @Throws(JsonParseException::class,
        JsonMappingException::class,
        IOException::class)
    fun saveProduct(@RequestParam("file") file: MultipartFile, @RequestParam("user") user: String?): ResponseEntity<Any> {
        val product1: User = ObjectMapper().readValue(user, User::class.java).also {
            it.profilePicture
        }
        userService.save(product1)
    }*/

}
