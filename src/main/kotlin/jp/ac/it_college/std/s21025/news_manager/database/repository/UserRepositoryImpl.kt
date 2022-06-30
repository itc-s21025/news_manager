package jp.ac.it_college.std.s21025.news_manager.database.repository

import jp.ac.it_college.std.s21025.news_manager.database.mapper.UserDynamicSqlSupport.users
import jp.ac.it_college.std.s21025.news_manager.database.mapper.UsersMapper
import jp.ac.it_college.std.s21025.news_manager.database.mapper.selectByPrimaryKey
import jp.ac.it_college.std.s21025.news_manager.database.record.User as RecordUser
import jp.ac.it_college.std.s21025.news_manager.domain.model.User
import jp.ac.it_college.std.s21025.news_manager.domain.repository.UserRepository
import jp.ac.it_college.std.s21025.news_manager.database.mapper.selectOne
import org.springframework.stereotype.Repository

@Repository

class UserRepositoryImpl(
    private val mapper: UsersMapper
) : UserRepository {
    override fun find(username: String): User? {
        val record = mapper.selectOne {
            where {
                users.username isEqualTo username
            }
        }
        return record?.let { toModel(it) }
    }

    override fun find(id: Long): User? {
        val record = mapper.selectByPrimaryKey(id)
        return record?.let { toModel(it) }
    }

    private fun toModel(record: RecordUser): User {
        return User(
            record.id!!,
            record.username!!,
            record.password!!,
            record.viewName!!,
            record.roleType!!
        )
    }
}
