BEGIN
  -- 2.1. Drop tất cả TRIGGER
  FOR trg IN (SELECT trigger_name FROM user_triggers) LOOP
    EXECUTE IMMEDIATE 'DROP TRIGGER "' || trg.trigger_name || '"';
  END LOOP;

  -- 2.2. Drop tất cả SEQUENCE
  FOR seq IN (SELECT sequence_name FROM user_sequences) LOOP
    EXECUTE IMMEDIATE 'DROP SEQUENCE "' || seq.sequence_name || '"';
  END LOOP;

  -- 2.3. Drop tất cả TABLE (kèm CASCADE CONSTRAINTS để đảm bảo xóa FK, index…)
  FOR tbl IN (SELECT table_name FROM user_tables) LOOP
    EXECUTE IMMEDIATE 'DROP TABLE "' || tbl.table_name || '" CASCADE CONSTRAINTS';
  END LOOP;
END;