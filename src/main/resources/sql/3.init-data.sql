delete from t_user;
delete from t_order;
call insert_data_user(1,1000);
call insert_data_order(1,1000);
COMMIT;