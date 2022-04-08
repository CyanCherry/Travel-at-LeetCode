function fourSumCount(nums1: number[], nums2: number[], nums3: number[], nums4: number[]): number {
  let result = 0;
  const map = new Map();
  for (let i = 0; i < nums1.length; i++) {
    for (let j = 0; j < nums2.length; j++) {
      const sum = nums1[i] + nums2[j];
      map.set(sum, (map.get(sum) ?? 0) + 1)
    }
  }
  for (let k = 0; k < nums3.length; k++) {
    for (let l = 0; l < nums4.length; l++) {
      const sum = nums3[k] + nums4[l];
      const count = map.get(-sum);
      result += count ?? 0
    }
  }
  return result;
}


console.log(fourSumCount(
  [1, 2],
  [-2, -1],
  [-1, 2],
  [0, 2],
) == 2);
console.log(fourSumCount(
  [0],
  [0],
  [0],
  [0],
) == 1);
console.log(fourSumCount(
  [-1, 1, 1, 1, -1],
  [0, -1, -1, 0, 1],
  [-1, -1, 1, -1, -1],
  [0, 1, 0, -1, -1],
) == 132);

