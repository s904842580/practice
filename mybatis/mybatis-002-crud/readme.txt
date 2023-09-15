使用mybatis完成CRUD

1.什么是CRUD
    C:Creat增
    R：Retrieve查
    U：Update改
    D:Delete删

2. insert
    <insert id="insertCar">
        insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
        values (null,'1003','本田霸道',30,'2000-10-11','燃油车')
    </insert>
    这样写的问题是？
        值 显然是写死到配置文件中的
        这个在实际开发中是不存在的
        一定是前端form表单提交过来的数据。然后将值传给sql语句

    例如：JDBC的代码是怎么写的？
        String sql = "insert into t_car(id,car_num,brand,guide_price,produce_time,car_type).value(null,?,?,?,?,?)";
        ps.setString(1, xxx);
        ps.setString(2, yyy);
        ....

    在JDBC当中占位符采用的是？，在mybatis当中是什么呢？
    和？等效的写法是: #{}
    在mybatis当中不能使用？占位符，必须使用 #{} 来代替JDBC当中的？
    #{} 和JDBC当中的 ？ 是等效的

    java程序中使用Map可以给sql语句的占位符传值
    Map<String, Object>map = new HashMap<String, Object>();
            map.put("k1","1111");
            map.put("k2","比亚迪汉");
            map.put("k3","10.0");
            map.put("k4","2020-11-11");
            map.put("k5","电车");

    insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values (null,#{k1},#{k2},#{k3},#{k4},#{k5})
    注意：#{这里写什么？ 写map集合的key，如果key不存在，获取的是null}
    一般map集合的key起名的时候要见名知意


    java程序中使用POJO类给SQL语句的占位符传值
        注意：占位符#{},大括号里面写：pojo类的属性名
        严格意义上来说：如果使用POJO对象传递值的话，#{}这个大括号中到底写什么？
            写的是get方法的方法名去掉get，然后将剩下的单词首字母小写，然后放进去
            例如：getUsername() -- > #{username}
        也就是说mybatis在底层给？传值的时候，先要获取值，怎么获取的？
            调用了pojo对象的get方法，例如：car.getCarNum()
3.delete
    *需求：根据id删除数据

    注意：如果占位符只有一个，那么#{}的大括号里可以随意。但是最好见名知意
4.update
    根据id修改某条记录
5.select(查一个，根据主键查询的话，返回的结果一定是一个)
    *需求：根据id查询

    实现：
        <select id="selectById" resultType="com.powernode.mybatis.pojo.Car">
                select * from t_car where id = #{id}
        </select>
        Object car = sqlSession.selectOne("selectById", 1);

        需要特别注意的是：
        select标签中resultType属性，这个属性用来告诉mybatis，查询结果集封装成什么类型的Java对象。你需要告诉mybatis
        resultType通常写的是：全限定类名

        Car{id=1, carNum='null', brand='宝马520Li', guidePrice=null, produceTime='null', carType='null'}
        输出结果不对：
            id和brand属性有值
            其他属性为null

        carNum以及其他的这几个属性没有赋值上的原因是什么
            列名和Car类名中的属性名对不上

6.select（查所有的）

    <select id="selectAll" resultType="com.powernode.mybatis.pojo.Car">
                select
                id,car_num as carNum,brand,guide_price as guidePrice,
                produce_time as produceTime,
                car_type as carType
            from
                t_car
    </select>

    List<Object> cars = sqlSession.selectList("selectAll");

    注意：resultType还是指定要封装的结果集的类型。不是指定List类型，是指定List集合中元素的类型
    selectList方法：mybatis通过这个方法就可以得知你需要一个List集合。它会自动给你返回一个List集合


7.在sql mapper.xml文件当中有一个namespace，这个属性是用来指定命名空间的。用防止id重复
    实际上，本质上，mybatis中的sqlId的完整写法
        namespace.id
        例：Object car = sqlSession.selectOne("selectById", 1);
            Object car = sqlSession.selectOne("org.mybatis.example.BlogMapper.selectById", 1);