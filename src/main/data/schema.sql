MERGE localcases USING -- source_table
ON merge_condition
WHEN MATCHED
    THEN --
WHEN NOT MATCHED
    THEN --
WHEN NOT MATCHED BY SOURCE
    THEN DELETE;

-- a lot of work needs to be completed