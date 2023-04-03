import * as React from 'react';

import { StyleSheet, Text, View } from 'react-native';
import { getStandbyBucketStatus } from 'react-native-appstandby-buckets';

export default function App() {
  const [result, setResult] = React.useState<String | undefined>(0);

  React.useEffect(() => {
    getStandbyBucketStatus().then((res: String) => {
      console.log(res);
      setResult(res);
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
