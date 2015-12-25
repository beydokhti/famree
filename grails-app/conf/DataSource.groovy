dataSource {
	pooled = true
}

hibernate {
    show_sql = false
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='org.hibernate.cache.EhCacheProvider'
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}

// environment specific settings
environments {
   
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop','update'
			driverClassName = "com.mysql.jdbc.Driver"
			username = "famree"
			password = "famree"
			url = "jdbc:mysql://localhost/famree?useUnicode=yes&characterEncoding=UTF-8"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			driverClassName = "com.mysql.jdbc.Driver"
			username = "familyTree"
			password = "familyTree"
			url = "jdbc:mysql://localhost/familyTree؟useUnicode=yes&characterEncoding=UTF-8"
		}
	}
	production {
		dataSource {
		    pooled = true
            // refer famree-config.properties
		}
	}
}