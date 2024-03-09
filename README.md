-> Let's consider an extended example with a more complex configuration object that includes nested properties. We'll have a default configuration for a blog application, and users can customize aspects such as the appearance, social media links, and notification settings.

// Default configuration for a blog application
const defaultConfig = {
  appearance: {
    theme: 'light',
    fontSize: 16,
  },
  socialMedia: {
    twitter: 'https://twitter.com/example',
    facebook: 'https://www.facebook.com/example',
    instagram: 'https://www.instagram.com/example',
  },
  notifications: {
    email: true,
    push: true,
  },
};

// User-specific preferences
const userPreferences = {
  appearance: {
    theme: 'dark',
  },
  socialMedia: {
    twitter: 'https://twitter.com/user_handle',
    instagram: 'https://www.instagram.com/user_handle',
  },
  notifications: {
    push: false,
  },
};

function deepMerge(target, ...sources) {
  if (!sources.length) return target;

  const source = sources.shift();

  for (const key in source) {
    if (isObject(source[key])) {
      if (!target[key] || !isObject(target[key])) {
        target[key] = {};
      }
      deepMerge(target[key], source[key]);
    } else {
      Object.assign(target, { [key]: source[key] });
    }
  }

  return deepMerge(target, ...sources);
}

function isObject(item) {
  return item && typeof item === 'object' && !Array.isArray(item);
}

// Combine default configuration with user preferences
const mergedConfig = deepMerge({}, defaultConfig, userPreferences);
console.log('Merged Configuration:', mergedConfig);


Explanation of deepMerge function:

Initial Check:

if (!sources.length) return target;: This checks if there are no more sources to merge. If so, it returns the target object.
Loop through Source Object:

const source = sources.shift();: This retrieves the next source object from the array of sources.
for (const key in source) {: It iterates over each property of the current source object.
Check if Property is an Object:

if (isObject(source[key])) {: This checks if the current property in the source object is itself an object.
Inside this block, it checks if the corresponding property in the target is also an object. If not, it initializes it as an empty object.
deepMerge(target[key], source[key]);: This recursively calls deepMerge to merge the nested objects.
Handle Non-Object Properties:

If the current property is not an object, it directly assigns the value to the target object using Object.assign.
Object.assign(target, { [key]: source[key] });
Recursive Call:

return deepMerge(target, ...sources);: After processing the current source object, the function calls itself recursively with the updated target and the remaining sources.
Helper Function:

function isObject(item) { ... }: This is a helper function that checks if a given item is an object and not an array.
Overall, the deepMerge function recursively traverses the source and target objects, merging them deeply while handling nested properties. It continues this process until all source objects are merged into the target. This kind of deep merging is essential when dealing with complex configuration objects that have nested structures.







