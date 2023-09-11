开发我的第一个mybatis程序

1.resource目录
    放在这个目录当中的，一般都是资源文件，配置文件
    直接放到resource目录下的资源，等同于放到了类的跟目录下

2.开发步骤

*第一步：打包方式jar
*第二步：引入依赖
    - mybatis依赖
    - mysql驱动依赖
*第三步：编写mybatis核心配置文件，mybatis-config.xml
    注意：
        第一，这个文件名不是必须叫做mybatis-config.xml，可以用其他的名字。只是大家都采用这个名字
        第二，这个名字存放的位置也不是固定的，可以随意，但一般情况下，会放到类的根路径下

    mybatis-config.xml文件中的配置信息不理解没关系，先把链接数据库的信息修改一下即可
    其他的别动
*第四步：编写XxxxMapper.xml文件
    在这个配置文件当中编写SQL语句
    这个文件名也不是固定的，放的位置也不是固定，我们这里给它起个名字，叫做：CarMapper.xml
    把它暂时放到类的根路径下。
*第五步：在mybatis-config.xml文件中指定XxxxMapper.xml文件的路径：
    <mapper resource="CarMapper.xml"/>
    注意：resource属性会自动从类的根路径下开始找资源
*第六步：编写MyBatis程序。(使用MyBatis的类库，编写MyBatis程序，链接数据库，做增删改查就行了)
    在MyBatis当中，负责执行SQL语句的那个对象叫做什么呢？
        SqlSession
    SqlSession是专门用来执行SQL语句的，是一个Java程序和数据库之间的一次会话
    要想获取SqlSession对象，需要先获取SqlSessionFactory对象，通过SqlSessionFactory工厂来生产SqlSession对象
    怎么获取SqlSessionFactory对象呢？
        需要首先获取SqlSessionFactoryBuilder对象
        通过SqlSessionFacBuilder对象的Build方法，来获取一个SqlSession对象

    MyBatis的核心对象包括：
        SqlSessionFactoryBuilder
        SqlSessionFactory
        SqlSession

    SqlSessionFactoryBuilder --> SqlSessionFactory --> SqlSession


3.从 XML 中构建 SqlSessionFactory
    通过官方的这句话，你能想到什么呢？
        第一：在mybatis中一定是有一个很重要的对象，这个对象是：SqlSessionFactory对象
        第二：SqlSessionFactory对象的创建需要XML
      SML是什么？
        它一定是一个配置文件

4.mybatis中有两个主要的配置文件：
    其中一个是：mybatis-config.xml